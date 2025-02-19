package com.arthur_moreira.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arthur_moreira.projeto.chain.Filtro;
import com.arthur_moreira.projeto.factory.RecomendacaoFactory;
import com.arthur_moreira.projeto.model.Filme;
import com.arthur_moreira.projeto.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	FilmeService filmeService;
	
    @GetMapping
    public List<Filme> recomendarFilmes(@RequestParam String genero, 
                                        @RequestParam String idade, 
                                        @RequestParam double popularidade) {
        Filtro recomendacao = RecomendacaoFactory.criarRecomendacao(genero, idade, popularidade);
        return recomendacao.aplicar(filmeService.buscarTodosFilmes());
    }
    
    @GetMapping("/todos")
    public List<Filme> listarTodosFilmes() {
        return filmeService.buscarTodosFilmes(); 
    }

   
}