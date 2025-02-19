package com.arthur_moreira.projeto.factory;

import com.arthur_moreira.projeto.chain.Filtro;
import com.arthur_moreira.projeto.chain.FiltroGenero;
import com.arthur_moreira.projeto.chain.FiltroIdade;
import com.arthur_moreira.projeto.chain.FiltroPopularidade;

public class RecomendacaoFactory {
    public static Filtro criarRecomendacao(String genero, String idade, double popularidade) {
        Filtro filtro = new FiltroPopularidade(popularidade, null);
        filtro = new FiltroIdade(idade, filtro);
        filtro = new FiltroGenero(genero, filtro);
        return filtro;
    }
}

