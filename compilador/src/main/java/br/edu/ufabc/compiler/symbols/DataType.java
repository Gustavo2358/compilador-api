package br.edu.ufabc.compiler.symbols;

public enum DataType {
    INTEIRO("inteiro", "int"),
    REAL("real", "double"),
    TEXTO("texto", "String"),
    LOGICO("logico", "boolean");

    private String typeName;
    private String javaType;

    DataType(String typeName, String javaType) {
        this.typeName = typeName;
        this.javaType = javaType;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getJavaType() {
        return javaType;
    }
}
