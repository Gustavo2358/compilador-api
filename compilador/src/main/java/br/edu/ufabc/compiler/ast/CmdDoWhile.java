package br.edu.ufabc.compiler.ast;

public class CmdDoWhile extends CmdWhile{

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        lista.forEach(command -> str.append(command.generateJavaCode()));
        return "do {\n "+ str + "\n} while(" + expr.toString()+ "); \n";
    }
}
