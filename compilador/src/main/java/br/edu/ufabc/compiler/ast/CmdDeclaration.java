package br.edu.ufabc.compiler.ast;

import br.edu.ufabc.compiler.symbols.DataType;
import br.edu.ufabc.compiler.symbols.Identifier;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiFunction;

public class CmdDeclaration implements Command {

    private final List<Identifier> ids;

    public CmdDeclaration(List<Identifier> ids) {
        this.ids = ids;
    }

    @Override
    public String generateJavaCode() {
        BiFunction<DataType, String, String> getJavaFormatted = (dt, s) ->
                String.format("%s %s;\n", dt.getJavaType(), s);
        return ids.size() == 1 ?
                generateVariableDeclarationCode(getJavaFormatted) :
                generateVariablesDeclarationCode(getJavaFormatted);
    }

    @Override
    public String generateJavaScriptCode() {
        BiFunction<DataType, String, String> getJavaScriptFormatted = (dt, s) ->
                String.format("%s %s;\n", "let", s);
        return ids.size() == 1 ?
                generateVariableDeclarationCode(getJavaScriptFormatted) :
                generateVariablesDeclarationCode(getJavaScriptFormatted);
    }

    private String generateVariableDeclarationCode(BiFunction<DataType,String,String> getFormatted) {
        Identifier identifier = ids.get(0);
        return getFormatted.apply(identifier.getType(), identifier.getName());
    }

    private String generateVariablesDeclarationCode(BiFunction<DataType,String,String> getFormatted) {
        StringJoiner sj = new StringJoiner(", ");
        ids.forEach(identifier -> sj.add(identifier.getName()));
        return getFormatted.apply(ids.get(0).getType(), sj.toString());
    }

    private static String getFormatted(DataType type, String variablesString) {
        return String.format("%s %s;\n", type.getJavaType(), variablesString);
    }


    @Override
    public void run() {
//        JOptionPane.showMessageDialog(null, (id!=null? id.getValue():text));
    }

}

