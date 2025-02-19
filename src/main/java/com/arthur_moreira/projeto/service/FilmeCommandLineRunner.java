package com.arthur_moreira.projeto.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FilmeCommandLineRunner implements CommandLineRunner {

    private final FilmeService filmeService;

    // Injeta o serviço FilmeService que contém o método salvarFilmes
    public FilmeCommandLineRunner(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Chama o método salvarFilmes ao iniciar a aplicação
        filmeService.salvarFilmes();
    }
}
