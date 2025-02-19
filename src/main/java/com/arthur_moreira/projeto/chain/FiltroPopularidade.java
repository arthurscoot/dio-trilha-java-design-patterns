package com.arthur_moreira.projeto.chain;

import java.util.List;
import java.util.stream.Collectors;

import com.arthur_moreira.projeto.model.Filme;

public class FiltroPopularidade implements Filtro {
    private double popularidade;
    private Filtro outroFiltro;

    public FiltroPopularidade(double popularidade, Filtro outroFiltro) {
        this.popularidade = popularidade;
        this.outroFiltro = outroFiltro;
    }

    @Override
    public List<Filme> aplicar(List<Filme> filmes) {
        List<Filme> filmesFiltrados = filmes.stream()
                .filter(filme -> filme.getPopularidade() >= popularidade)
                .collect(Collectors.toList());

        if (outroFiltro != null) {
            return outroFiltro.aplicar(filmesFiltrados);
        }
        return filmesFiltrados;
    }
}

