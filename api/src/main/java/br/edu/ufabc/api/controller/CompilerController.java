package br.edu.ufabc.api.controller;

import br.edu.ufabc.api.Service.CompilerService;
import br.edu.ufabc.api.response.ApiResponse;
import br.edu.ufabc.compiler.exception.CompilationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("compiler-api/v1/file-upload")
public class CompilerController {

    private final CompilerService compilerService;

    public CompilerController(CompilerService compilerService) {
        this.compilerService = compilerService;
    }

    @PostMapping("/to-java")
    public ResponseEntity<ApiResponse<String>> generateJavaCode(@RequestParam("file") MultipartFile sourceFile) throws IOException {

        String javaCode = compilerService.compileToJava(sourceFile);
        ApiResponse<String> response = new ApiResponse<>(
                true,
                "Compilation Successful",
                javaCode,
                Collections.emptyList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/to-javaScript")
    public ResponseEntity<ApiResponse<String>> generateJavaScriptCode(@RequestParam("file") MultipartFile sourceFile) throws IOException {

        String javaCode = compilerService.compileToJavaScript(sourceFile);
        ApiResponse<String> response = new ApiResponse<>(
                true,
                "Compilation Successful",
                javaCode,
                Collections.emptyList());
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(CompilationException.class)
    public ResponseEntity<ApiResponse<String>> handleCompilationError(CompilationException ex) {
        ApiResponse<String> response = new ApiResponse<>(false,
                "Compilation failed",
                "",
                List.of(ex.getMessage().split("\\n")));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
