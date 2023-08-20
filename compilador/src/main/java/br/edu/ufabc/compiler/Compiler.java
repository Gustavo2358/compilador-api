package br.edu.ufabc.compiler;

import br.edu.ufabc.compiler.error.CollectingErrorListener;
import br.edu.ufabc.compiler.exception.CompilationException;
import br.edu.ufabc.compiler.parser.GrammarLexer;
import br.edu.ufabc.compiler.parser.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;
import java.util.stream.Collectors;

public class Compiler {

    public String compileToJava(String source){
        try {
            GrammarParser parser = parse(source);
            return parser.generateJavaCode();
        }
        catch(Exception e) {
//            System.err.println("Compilation Fail");
//            System.err.println(e.getMessage());
//            e.printStackTrace();
             throw new CompilationException(e.getMessage());
        }
    }

    public String compileToJavaScript(String source){
        try {
            GrammarParser parser = parse(source);
            return parser.generateJavaScriptCode();
        }
        catch(Exception e) {
//            System.err.println("Compilation Fail");
//            System.err.println(e.getMessage());
//            e.printStackTrace();
            throw new CompilationException(e.getMessage());
        }
    }

    private static GrammarParser parse(String source) throws Exception {
        GrammarLexer lexer;
        GrammarParser parser;

        //Error listener customizado para coletar os erros.
        CollectingErrorListener errorListener = new CollectingErrorListener();

        // crio o lexer a partir da leitura do arquivo de entrada
        lexer = new GrammarLexer(CharStreams.fromString(source));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        // crio o TokenStream (o fluxo de tokens) a partir do lexer
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        // crio o parser a partir do tokenStream
        parser = new GrammarParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        parser.prog();

        List<String> errors = errorListener.getErrors();
        if (!errors.isEmpty()) {
            String strErr = errors.stream()
                    .map(e -> e + "\n")
                    .collect(Collectors.joining());
            throw new Exception(strErr);
        }

//            parser.exibirTodosTokens();
//            parser.exibirSimbolos();
//            parser.generateObjectCode();
        return parser;
    }
}
