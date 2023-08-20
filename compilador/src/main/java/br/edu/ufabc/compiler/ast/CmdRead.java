package br.edu.ufabc.compiler.ast;

import br.edu.ufabc.compiler.exception.SemanticException;
import br.edu.ufabc.compiler.symbols.DataType;
import br.edu.ufabc.compiler.symbols.Identifier;

import javax.swing.JOptionPane;


public class CmdRead implements Command {

    private Identifier id;

    public CmdRead(Identifier id) {
        this.id = id;
    }
    public CmdRead() {
    }


    @Override
    public String generateJavaCode() {
        return switch (id.getType()){
            case INTEIRO -> id.getName() + " = " + "sc.nextInt();\n";
            case REAL -> id.getName() + " = " + "sc.nextDouble();\n";
            case TEXTO -> id.getName() + " = " + "sc.nextLine();\n";
            case LOGICO -> throw new SemanticException(
                    "Nao é possível utilizar o comando leia para variáveis do tipo LOGICO");
        };
    }
    @Override
    public void run() {
//        id.setValue(Integer.parseInt(JOptionPane.showInputDialog("Type Your Input")));
    }

}
