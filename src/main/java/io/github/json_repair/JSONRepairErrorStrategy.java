package io.github.json_repair;

import org.antlr.v4.runtime.*;

class JSONRepairErrorStrategy extends DefaultErrorStrategy {
    TokenStreamRewriter rewriter;
    JSONRepairErrorListener lexerErrorListener;

    public JSONRepairErrorStrategy(TokenStreamRewriter rewriter, JSONRepairErrorListener lexerErrorListener) {
        this.lexerErrorListener = lexerErrorListener;
        this.rewriter = rewriter;
    }

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        throw new InputMismatchException(recognizer);
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        throw new InputMismatchException(recognizer);
    }
    @Override
    public void sync(Parser recognizer) {
        // do not sync
    }
}
