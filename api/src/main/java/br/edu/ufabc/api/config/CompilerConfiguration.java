package br.edu.ufabc.api.config;

import br.edu.ufabc.compiler.Compiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompilerConfiguration {

    @Bean
    public Compiler getCompiler(){
        return new Compiler();
    }
}
