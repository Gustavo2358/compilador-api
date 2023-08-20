package br.edu.ufabc.compiler.expression;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BinaryExpression implements Expression {

    private String operator;
    private Expression leftSide;
    private Expression rightSide;

    public String eval() {

        //Usando operações com BigDecimal para que a String resultante fique corretamente formatada, alem
        //de melhorar a precisão do calculo.
        return switch(operator) {
            case "+" ->
                new BigDecimal(leftSide.eval()).add( new BigDecimal(rightSide.eval())).toString();
            case "-" ->
                new BigDecimal(leftSide.eval()).subtract( new BigDecimal(rightSide.eval())).toString();
            case "*" ->
                new BigDecimal(leftSide.eval()).multiply( new BigDecimal(rightSide.eval())).toString();
            case "/" ->
                 new BigDecimal(leftSide.eval()).setScale(16).divide( new BigDecimal(rightSide.eval()), RoundingMode.HALF_UP).toString();
            case "//" ->
                new BigDecimal(leftSide.eval())
                        .setScale(16)
                        .divide( new BigDecimal(rightSide.eval()), RoundingMode.HALF_UP)
                        .toString()
                        .split("\\.")[0];
            case "<" ->
                    (new BigDecimal(leftSide.eval()).setScale(16).compareTo( new BigDecimal(rightSide.eval())) == -1)
                            ? String.valueOf(true) :
                              String.valueOf(false);
            case ">" ->
                    (new BigDecimal(leftSide.eval()).setScale(16).compareTo( new BigDecimal(rightSide.eval())) == 1)
                            ? String.valueOf(true) :
                            String.valueOf(false);
            case "==" ->
                    (new BigDecimal(leftSide.eval()).setScale(16).compareTo( new BigDecimal(rightSide.eval())) == 0)
                            ? String.valueOf(true) :
                            String.valueOf(false);
            case "!=" ->
                    (new BigDecimal(leftSide.eval()).setScale(16).compareTo( new BigDecimal(rightSide.eval())) != 0)
                            ? String.valueOf(true) :
                            String.valueOf(false);
            case "<=" ->
                    (new BigDecimal(leftSide.eval()).setScale(16).compareTo( new BigDecimal(rightSide.eval())) <= 0)
                            ? String.valueOf(true) :
                            String.valueOf(false);
            case ">=" ->
                    (new BigDecimal(leftSide.eval()).setScale(16).compareTo( new BigDecimal(rightSide.eval())) >= 0)
                            ? String.valueOf(true) :
                            String.valueOf(false);
            case "&&" ->
                    String.valueOf(leftSide.eval().equals("true") && rightSide.eval().equals("true")) ;
            case "||" ->
                    String.valueOf(leftSide.eval().equals("true") || rightSide.eval().equals("true")) ;
            default -> throw new IllegalStateException("Operador inválido: " + operator);
        };
    }

    public BinaryExpression(String operator, Expression leftSide, Expression rightSide) {
        this.operator = operator;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public BinaryExpression(String operator) {
        this.operator = operator;
    }

    public String toString() {
        String left = (leftSide instanceof BinaryExpression ||
                leftSide instanceof BooleanExpression) ? "("+leftSide+")" : leftSide.toString() ;
        String right = (rightSide instanceof BinaryExpression ||
                rightSide instanceof BooleanExpression) ? "("+rightSide+")" : rightSide.toString() ;
        return left + operator + right;
    }

    private boolean isBooleanExpression(Expression expression){
        return expression.toString().contains("&&") ||
            expression.toString().contains("||");
    }
    public void setLeftSide(Expression leftSide) {
        this.leftSide = leftSide;
    }
    public void setRightSide(Expression rightSide) {
        this.rightSide = rightSide;
    }
}
