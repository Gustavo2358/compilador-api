package br.edu.ufabc.compiler.expression;

public class IntegerNumberExpression implements Expression {
    private Integer numberValue;

    public IntegerNumberExpression(Integer numberValue) {
        this.numberValue = numberValue;
    }

    public Integer getNumberValue() {
        return numberValue;
    }

    @Override
    public String eval() {
        return String.valueOf(numberValue);
    }

    public String toString(){
        return String.valueOf(numberValue);
    }
}
