package br.edu.ufabc.compiler.ast;

import br.edu.ufabc.compiler.expression.Expression;

import java.util.List;

public class CmdIf implements Command{

    private Expression expr;
    private List<Command> listaTrue;
    private List<Command> listaFalse;

    public CmdIf() {
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public void setListaTrue(List<Command> listaTrue) {
        this.listaTrue = listaTrue;
    }

    public void setListaFalse(List<Command> listaFalse) {
        this.listaFalse = listaFalse;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder str = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (Command cmd: listaTrue) {
            str.append(cmd.generateJavaCode());
        }
        if (listaFalse != null /*&& !listaFalse.isEmpty()*/) {
            str2.append("else {\n");
            for (Command cmd: listaFalse) {
                str2.append(cmd.generateJavaCode());
            }
            str2.append("\n}\n");
        }
        return "if (" + expr.toString()+ ") {\n "+ str + "\n}\n"+str2;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }

}
