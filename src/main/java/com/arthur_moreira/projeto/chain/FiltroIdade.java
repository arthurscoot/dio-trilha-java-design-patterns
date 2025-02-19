package com.arthur_moreira.projeto.chain;

import java.util.List;
import java.util.stream.Collectors;

import com.arthur_moreira.projeto.model.Filme;

public class FiltroIdade implements Filtro {
    private String idade;
    private Filtro outroFiltro;

    public FiltroIdade(String idade, Filtro outroFiltro) {
        this.idade = idade;
        this.outroFiltro = outroFiltro;
    }

    @Override
    public List<Filme> aplicar(List<Filme> filmes) {
        List<Filme> filmesFiltrados = filmes.stream()
                .filter(filme -> filme.getIdade().equals(idade))
                .collect(Collectors.toList());

        if (outroFiltro != null) {
            return outroFiltro.aplicar(filmesFiltrados);
        }
        return filmesFiltrados;
    }
}
