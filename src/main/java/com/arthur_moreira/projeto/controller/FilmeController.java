package com.arthur_moreira.projeto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arthur_moreira.projeto.chain.Filtro;
import com.arthur_moreira.projeto.exception.FilmeNaoEncontradoException;
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
	                                        @RequestParam Double popularidade) {
		 
		 if (genero == null || genero.isEmpty() || idade == null || idade.isEmpty() || popularidade == null || popularidade <= 0) {
	            throw new FilmeNaoEncontradoException("Informações incorretas. Por favor, forneça todos os parâmetros corretamente.");
	        }
		 
	        Filtro recomendacao = RecomendacaoFactory.criarRecomendacao(genero, idade, popularidade);
	        List<Filme> filmesRecomendados = recomendacao.aplicar(filmeService.buscarTodosFilmes());

	        if (filmesRecomendados.isEmpty()) {
	            throw new FilmeNaoEncontradoException("Nenhum filme encontrado com os critérios fornecidos.");
	        }

	        return filmesRecomendados;
	    }

	    @ExceptionHandler(FilmeNaoEncontradoException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND) 
	    public ResponseEntity<?> handleFilmeNaoEncontrado(FilmeNaoEncontradoException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(Map.of("erro", ex.getMessage()));
	    }

    @GetMapping("/todos")
    public ResponseEntity<?> listarTodosFilmes() {
        try {
            List<Filme> filmes = filmeService.buscarTodosFilmes();
            return ResponseEntity.ok(filmes);
        } catch (FilmeNaoEncontradoException ex) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Filmes não encontrados");
            response.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<?> adicionarFilme(@RequestBody Filme filme) {
        try {
            if (filme.getNome() == null || filme.getNome().isEmpty()) {
                throw new FilmeNaoEncontradoException("Título do filme é obrigatório.");
            }
            if (filme.getGenero() == null || filme.getGenero().isEmpty()) {
                throw new FilmeNaoEncontradoException("Gênero do filme é obrigatório.");
            }
            if (filme.getIdade() == null || filme.getIdade().isEmpty()) {
                throw new FilmeNaoEncontradoException("Idade do filme é obrigatória.");
            }
       
           filmeService.salvarFilme(filme);
          
            return ResponseEntity.status(HttpStatus.CREATED).body(filme);
        } catch (FilmeNaoEncontradoException ex) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Dados inválidos");
            response.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception ex) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Erro ao salvar filme");
            response.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    
   
}