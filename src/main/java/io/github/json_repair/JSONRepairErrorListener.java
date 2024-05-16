package io.github.json_repair;

import io.github.json_repair.antlr.JSONLexer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

class JSONRepairErrorListener extends BaseErrorListener {
    private final int UNKNOWN_TYPE = -1;
    private final List<Token> missedCharacters = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        if (recognizer instanceof JSONLexer) {
            JSONLexer lexer = (JSONLexer) recognizer;
            if (offendingSymbol instanceof Token) {
                missedCharacters.add((Token) offendingSymbol);
            } else {
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
