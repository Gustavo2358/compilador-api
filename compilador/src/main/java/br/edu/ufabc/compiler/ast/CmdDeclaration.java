package br.edu.ufabc.compiler.ast;

import br.edu.ufabc.compiler.symbols.DataType;
import br.edu.ufabc.compiler.symbols.Identifier;

import java.util.List;
import java.util.StringJoiner;

public class CmdDeclaration implements Command {

    private final List<Identifier> ids;

    public CmdDeclaration(List<Identifier> ids) {
        this.ids = ids;
    }

    @Override
    public String generateJavaCode() {
        return ids.size() == 1 ?
                generateVariableDeclarationCode() :
                generateVariablesDeclarationCode();

    }

    private String generateVariableDeclarationCode() {
        Identifier identifier = ids.get(0);
        return getFormatted(identifier.getType(), identifier.getName());
    }

    private String generateVariablesDeclarationCode() {
        StringJoiner sj = new StringJoiner(", ");
        ids.forEach(identifier -> sj.add(identifier.getName()));
        return getFormatted(ids.get(0).getType(), sj.toString());
    }

    private static String getFormatted(DataType type, String variablesString) {
        return String.format("%s %s;\n", type.getJavaType(), variablesString);
    }


    @Override
    public void run() {
//        JOptionPane.showMessageDialog(null, (id!=null? id.getValue():text));
    }

}

