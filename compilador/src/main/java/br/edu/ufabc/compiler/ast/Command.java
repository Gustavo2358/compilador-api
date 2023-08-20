package br.edu.ufabc.compiler.ast;

public interface Command {
    String generateJavaCode();
    void run();
}
