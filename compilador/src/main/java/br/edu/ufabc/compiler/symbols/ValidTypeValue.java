package br.edu.ufabc.compiler.symbols;

import br.edu.ufabc.compiler.exception.TypeException;

import java.util.function.Consumer;

public class ValidTypeValue {

    private final String stringValue;
    public ValidTypeValue(Identifier identifier, String stringValue) {
        validateType(identifier, stringValue);
        this.stringValue = stringValue;
    }

    private void validateType(Identifier id, String stringValue){
        switch (id.getType()){

            case INTEIRO -> {
                validate(Integer::parseInt, id, stringValue);
            }
            case REAL -> {
                validate(Double::parseDouble, id, stringValue);
            }
            case TEXTO -> {
                validate((s) -> {
                    if (!(s.startsWith("\"") && s.endsWith("\"")))
                        throw new RuntimeException();
                }, id, stringValue);
            }
            case LOGICO -> {
                validate((s) -> {
                    if (!s.equals("true") && !s.equals("false"))
                        throw new RuntimeException();
                }, id, stringValue);
            }
        }
    }

    private static void validate(Consumer<String> parser, Identifier id, String stringValue) {
        try {
            parser.accept(stringValue);
        } catch (RuntimeException e){
            throw new TypeException("Atribuição incorreta. " +
                    "Variável '"+ id.getName()+"' esperando " + id.getType() + " mas recebeu " + identifyLiteral(stringValue) + ".");
        }
    }

    public static String identifyLiteral(String s) {
        if (s == null) return "Unknown";

        // Check for null literal
        if (s.equals("null")) return "Null Literal";

        // Check for boolean literals
        if (s.equals("true") || s.equals("false")) return "LOGICO";

        // Check for string literals
        if (s.startsWith("\"") && s.endsWith("\"")) return "TEXTO";

        // Check for char literals
        if (s.startsWith("'") && s.endsWith("'")) return "TEXTO";

        // Check for integer literals: Hexadecimal, Octal, Binary
        if (s.startsWith("0x") || s.startsWith("0X")) return "HEXADECIMAL Literal";
        if (s.startsWith("0b") || s.startsWith("0B")) return "BINARY Literal";
        if (s.startsWith("0")) return "OCTAL Literal";

        // Check for standard integer literals
        try {
            Integer.parseInt(s);
            return "INTEIRO";
        } catch (NumberFormatException ignored) { }

        // Check for floating-point literals
        try {
            Float.parseFloat(s);
            return "REAL";
        } catch (NumberFormatException ignored) { }

        try {
            Double.parseDouble(s);
            return "REAL";
        } catch (NumberFormatException ignored) { }

        return "Desconhecido";
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return "ValidTypeValue{" +
                 stringValue +
                '}';
    }
}
