package br.edu.ufabc.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping("compiler-api/v1/file-upload")
public class CompilerController {

    @GetMapping("/teste")
    public String teste(){
        return "funciona";
    }

    @PostMapping("/to-java")
    public ResponseEntity<String> generateJavaCode(@RequestParam("file") MultipartFile sourceFile) throws IOException {

        InputStream inputStream = sourceFile.getInputStream();
        return ResponseEntity.ok(inputStreamToString(inputStream));
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
