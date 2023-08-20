package br.edu.ufabc.compiler.ast;

import br.edu.ufabc.compiler.symbols.SymbolTable;

import java.util.ArrayList;
import java.util.List;


public class Program {

    private String filename;
    private List<Command> comandos;
    private SymbolTable symbolTable;

    private boolean existReadCmd;

    public Program() {
        this.filename = "Main.java";
        this.comandos = new ArrayList<>();
    }
    public String generateJavaCode(){

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format("""
                              import java.util.Scanner;
                              
                              public class %s{
                              public static void main(String[] args){
                              """, filename.split("\\.")[0]));
        comandos.forEach(c -> {
//                System.out.print(c.generateCode());
            if(c instanceof CmdRead && !existReadCmd) {
                strBuilder.append("Scanner sc = new Scanner(System.in);\n");
                existReadCmd = true;
            }
            strBuilder.append(c.generateJavaCode());
        });
        if(existReadCmd) strBuilder.append("sc.close();\n");
        strBuilder.append("""
                    }
                    }
                    """);
        return strBuilder.toString();
    }

    public String generateJavaScriptCode(){

        StringBuilder strBuilder = new StringBuilder();
        comandos.forEach(c -> {
//                System.out.print(c.generateCode());
            strBuilder.append(c.generateJavaScriptCode());
        });
        return strBuilder.toString();
    }
    public List<Command> getComandos() {
        return comandos;
    }

    public void setComandos(List<Command> comandos) {
        this.comandos = comandos;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public void run() {
//        RuntimeEntity runtime = new RuntimeEntity();
//        runtime.updateContent(symbolTable.getSymbols().values());
//        comandos.forEach(c -> {
//            c.run();
//            runtime.updateContent(symbolTable.getSymbols().values());
//        });
    }
}