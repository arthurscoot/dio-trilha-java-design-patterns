package com.arthur_moreira.projeto.chain;

import java.util.List;
import java.util.stream.Collectors;

import com.arthur_moreira.projeto.model.Filme;

public class FiltroGenero implements Filtro {
    private String genero;
    private Filtro outroFiltro;

    public FiltroGenero(String genero, Filtro outroFiltro) {
        this.genero = genero;
        this.outroFiltro = outroFiltro;
    }

    @Override
    public List<Filme> aplicar(List<Filme> filmes) {
        List<Filme> filmesFiltrados = filmes.stream()
                .filter(filme -> filme.getGenero().equals(genero))
                .collect(Collectors.toList());

        if (outroFiltro != null) {
            return outroFiltro.aplicar(filmesFiltrados);
        }
        return filmesFiltrados;
    }
}

