package br.edu.ufabc.api.Service;

import br.edu.ufabc.compiler.Compiler;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class CompilerService {

    private final Compiler compiler;

    public CompilerService(Compiler compiler) {
        this.compiler = compiler;
    }

    public String compile(MultipartFile sourceFile) throws IOException {
        InputStream inputStream = sourceFile.getInputStream();
        return compiler.compileToJava(inputStreamToString(inputStream));
    }
    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
