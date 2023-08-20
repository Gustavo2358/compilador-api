package br.edu.ufabc.compiler.expression;

public class BooleanExpression implements Expression {
    private Boolean bool;

    public BooleanExpression(Boolean bool) {
        this.bool = bool;
    }
    @Override
    public String eval() {
        return String.valueOf(bool);
    }

    public String toString(){
        return String.valueOf(bool);
    }
}
