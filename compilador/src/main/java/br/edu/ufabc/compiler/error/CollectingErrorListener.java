package br.edu.ufabc.compiler.error;

import org.antlr.v4.runtime.*;
import java.util.ArrayList;
import java.util.List;

public class CollectingErrorListener extends BaseErrorListener {

    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        String error = String.format("line %d:%d - %s", line, charPositionInLine, msg);
        errors.add(error);
    }


    public List<String> getErrors() {
        return errors;
    }
}