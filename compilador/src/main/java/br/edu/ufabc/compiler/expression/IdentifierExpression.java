package br.edu.ufabc.compiler.expression;

import br.edu.ufabc.compiler.symbols.Identifier;

public class IdentifierExpression implements Expression {
    private Identifier id;

    public IdentifierExpression(Identifier id) {
        this.id = id;
    }

    @Override
    public String eval() {
        return id.getValue().orElseThrow().getStringValue();
    }

    public String toString(){
        return id.getName();
    }
}
