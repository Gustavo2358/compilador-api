package br.edu.ufabc.compiler.ast;

import br.edu.ufabc.compiler.expression.Expression;

import java.util.List;

public class CmdWhile implements Command{

    protected Expression expr;
    protected List<Command> lista;

    public CmdWhile() {
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public void setLista(List<Command> lista){
        this.lista = lista;
    }
    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        lista.forEach(command -> str.append(command.generateJavaCode()));
        return "while (" + expr.toString()+ ") {\n "+ str + "\n}\n";
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

}
