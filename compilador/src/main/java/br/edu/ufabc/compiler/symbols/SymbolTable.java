package br.edu.ufabc.compiler.symbols;

import br.edu.ufabc.compiler.exception.SemanticException;
import br.edu.ufabc.compiler.expression.Expression;

import java.util.HashMap;

public class SymbolTable {

    private final HashMap<String, Identifier> symbols;
    public SymbolTable() {
        this.symbols = new HashMap<>();
    }

    public Identifier get(String key) {
        return this.symbols.get(key);
    }

    public void declareVariable(String name, DataType type) {
        if(exists(name))
            throw new SemanticException(String.format("A variável '%s' ja foi declarada.", name));
        this.symbols.put(name, new Identifier(name, type));
    }

    public void assignValue(String name, Expression expression){
        checkDeclaration(name);
        Identifier identifier = get(name);
        String stringValue = expression.eval();
        this.symbols.put(name, new Identifier(identifier.getName(), identifier.getType(), new ValidTypeValue(identifier, stringValue)));
    }

    public void checkUsage(String name){
        checkDeclaration(name);
        checkInitialization(name);
    }
    public void checkDeclaration(String name){
        if(!exists(name))
           throw new SemanticException(String.format("A variável '%s' não foi declarada.", name));
    }

    public void checkInitialization(String name){
        if(this.symbols.get(name).getValue().isEmpty())
            throw new SemanticException(String.format("A variável '%s' não foi inicializada.", name));
    }

    public boolean exists(String key) {
        return this.symbols.containsKey(key);
    }

    @Override
    public String toString() {
        return "SymbolTable{" +
                "symbols=" + symbols +
                '}';
    }
}
