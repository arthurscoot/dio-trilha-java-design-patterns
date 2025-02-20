package com.arthur_moreira.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arthur_moreira.projeto.exception.FilmeNaoEncontradoException;
import com.arthur_moreira.projeto.exception.ListaVaziaException;
import com.arthur_moreira.projeto.model.Filme;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class FilmeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvarFilmes(List<Filme> filmes) {
        if (filmes == null || filmes.isEmpty()) {
            throw new ListaVaziaException("A lista de filmes está vazia.");
        }

        for (Filme filme : filmes) {
            entityManager.persist(filme);
        }

        System.out.println("Filmes adicionados com sucesso.");
    }

    @Transactional
    public void salvarFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("O filme não pode ser nulo.");
        }

        entityManager.persist(filme);
        System.out.println("Filme adicionado com sucesso.");
    }
 

    public List<Filme> buscarTodosFilmes() {
        List<Filme> filmes = entityManager.createQuery("SELECT f FROM Filme f", Filme.class)
                                          .getResultList();

        if (filmes.isEmpty()) {
            throw new FilmeNaoEncontradoException("Nenhum filme encontrado.");
        }

        System.out.println("Filmes encontrados: " + filmes.size());
        return filmes;
    }
}
