package com.arthur_moreira.projeto.chain;

import java.util.List;

import com.arthur_moreira.projeto.model.Filme;

public interface Filtro {
    List<Filme> aplicar(List<Filme> filmes);
}

