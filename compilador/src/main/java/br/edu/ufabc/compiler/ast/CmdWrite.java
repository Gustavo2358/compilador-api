package br.edu.ufabc.compiler.ast;

import br.edu.ufabc.compiler.symbols.Identifier;

import javax.swing.JOptionPane;

public class CmdWrite implements Command {

    private Identifier id;
    private String text;

    public CmdWrite(Identifier id) {
        super();
        this.id = id;
    }

    public CmdWrite(String text) {
        this.text = text;
    }

    @Override
    public String generateJavaCode() {
        return "System.out.println(" + (id != null ? id.getName() : text) + ");\n";
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void run() {
//        JOptionPane.showMessageDialog(null, (id!=null? id.getValue():text));
    }

}

