package br.edu.ufabc.compiler.expression;

public class DoubleNumberExpression implements Expression {
    private Double numberValue;

    public DoubleNumberExpression(Double numberValue) {
        this.numberValue = numberValue;
    }

    public Double getNumberValue() {
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
