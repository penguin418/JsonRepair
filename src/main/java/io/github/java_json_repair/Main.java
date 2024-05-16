
package io.github.java_json_repair;

import io.github.java_json_repair.antlr.JSONLexer;
import io.github.java_json_repair.antlr.JSONParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

class CustomMismatchedTokenException extends InputMismatchException {
    private final TokenStreamRewriter rewriter;
    private final List<Token> missedCharacters;

    public CustomMismatchedTokenException(Parser recognizer, TokenStreamRewriter rewriter, List<Token> missedCharacters) {
        super(recognizer);
        this.rewriter = rewriter;
        this.missedCharacters = missedCharacters;
    }

    public TokenStreamRewriter getRewriter() {
        return rewriter;
    }

    public List<Token> getMissedCharacters() {
        return missedCharacters;
    }
}

class CustomLexerErrorListener extends BaseErrorListener {
    private final int UNKNOWN_TYPE = -1;
    private final List<Token> missedCharacters = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        if (recognizer instanceof JSONLexer){
            JSONLexer lexer = (JSONLexer) recognizer;
            if (offendingSymbol instanceof Token){
                missedCharacters.add((Token) offendingSymbol);
            }else{
                // 아래는 recognizer.getTokenFactory() 를 사용하는 것과 동일한 코드
                LexerNoViableAltException le = (LexerNoViableAltException) e;
                int errIdx = le.getStartIndex();
                Pair<TokenSource, CharStream> source = new Pair<>(lexer, lexer.getInputStream());
                missedCharacters.add(new CommonToken(source, UNKNOWN_TYPE, Token.DEFAULT_CHANNEL, errIdx, errIdx));
            }
        }
    }

    public List<Token> getMissedCharacters() {
        return missedCharacters;
    }
}


class JSONErrorHandler extends DefaultErrorStrategy {
    TokenStreamRewriter rewriter;
    CustomLexerErrorListener lexerErrorListener;
    public JSONErrorHandler(TokenStreamRewriter rewriter, CustomLexerErrorListener lexerErrorListener) {
        this.lexerErrorListener = lexerErrorListener;
        this.rewriter = rewriter;
    }

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw new CustomMismatchedTokenException(recognizer, rewriter, lexerErrorListener.getMissedCharacters());
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        throw new CustomMismatchedTokenException(recognizer, rewriter, lexerErrorListener.getMissedCharacters());
    }

    @Override
    public void sync(Parser recognizer) {
        // 기본 동기화 로직 사용
    }
}

public class Main{
    public static String repair(String jsonString){

        try {
            CodePointCharStream input = CharStreams.fromString(jsonString);
            JSONLexer lexer = new JSONLexer(input);
            lexer.removeErrorListeners();
            CustomLexerErrorListener lexerErrorListener = new CustomLexerErrorListener();
            lexer.addErrorListener(lexerErrorListener);


            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JSONParser parser = new JSONParser(tokens);
            TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
            parser.setErrorHandler(new JSONErrorHandler(rewriter, lexerErrorListener));
            parser.json();
        }catch (CustomMismatchedTokenException e) {
            Parser recognizer = (Parser)e.getRecognizer();
            List<Token> mismatched = e.getMissedCharacters();
            TokenFactory<?> factory = recognizer.getTokenFactory();

            Token offendingToken = e.getOffendingToken();
            Token previousToken = recognizer.getInputStream().LT(-1);
            String offendingRule = JSONLexer.ruleNames[offendingToken.getType() - 1];
            String previousRule = JSONLexer.ruleNames[previousToken.getType() - 1];
            String offendingText = offendingToken.getText();
            if ("STRING".equals(offendingRule) && "STRING".equals(previousRule) && offendingText.startsWith(",")){

                // TODO: rewriter 의 토큰과, jsonString 의 남은 입력과, mismatched 를 활용하여 json 을 고치고,
                //  다시 실행
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String jsonString = "{\n" +
                "  \"name\": \"John\",\n" +
                "  \"age\": 30,\n" +
                "  \"cars\": {\n" +
                "    \"cab1\": \"F\"ord\",\n" +
                "    \"cab2\": \"BMW\",\n" +
                "    \"cab3\": \"Fiat\"\n" +
                "  }\n" +
                "}";

        try {
            System.out.println(Main.repair(jsonString));
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}