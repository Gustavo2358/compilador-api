package br.edu.ufabc.compiler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath = "input.isi";  // Replace with your file path
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            generateTarget(new Compiler().compileToJava(content), "Main.java");
            generateTarget(new Compiler().compileToJavaScript(content), "src.js");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void generateTarget(String source, String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(source);
            pw.close();
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}