
package io.github.json_repair;

import io.github.json_repair.antlr.JSONLexer;
import io.github.json_repair.antlr.JSONParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;


public class JSONRepair {
    public static String repair(String jsonString) {
        while (true) {
            CodePointCharStream input = CharStreams.fromString(jsonString);
            JSONLexer lexer = new JSONLexer(input);
            lexer.removeErrorListeners();
            JSONRepairErrorListener lexerErrorListener = new JSONRepairErrorListener();
            lexer.addErrorListener(lexerErrorListener);


            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JSONParser parser = new JSONParser(tokens);
            TokenStreamRewriter rewriter = new TokenStreamRewriter(tokens);
            parser.setErrorHandler(new JSONRepairErrorStrategy(rewriter, lexerErrorListener));
            try {
                parser.json();
            } catch (InputMismatchException e) {
                Parser recognizer = (Parser) e.getRecognizer();
                List<Token> mismatched = lexerErrorListener.getMissedCharacters();

                Token offendingToken = e.getOffendingToken();
                Token previousToken = recognizer.getInputStream().LT(-1);
                String offendingRule = JSONLexer.ruleNames[offendingToken.getType() - 1];
                String previousRule = JSONLexer.ruleNames[previousToken.getType() - 1];
                String offendingText = offendingToken.getText();
                if ("STRING".equals(previousRule) && "STRING".equals(offendingRule) && offendingText.startsWith("\"")) {
                    jsonString = new StringBuilder(jsonString).insert(previousToken.getStopIndex(), "\\").toString();
                }
                continue;
            }
            return jsonString;
        }
    }
}