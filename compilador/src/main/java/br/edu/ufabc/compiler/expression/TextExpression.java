package br.edu.ufabc.compiler.expression;

public class TextExpression implements Expression {
    private String text;

    public TextExpression(String numberValue) {
        this.text = numberValue;
    }

    public String getText() {
        return text;
    }

    @Override
    public String eval() {
        return String.valueOf(text);
    }

    public String toString(){
        return text;
    }
}
