package com.arthur_moreira.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_filme")
	public class Filme {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String nome;
	    private String genero;
	    private String idade;
	    private Double popularidade;

	    public Filme() {
	    	
	    }
	    
	    public Filme(String nome, String genero, String idade, Double popularidade) {
	        this.nome = nome;
	        this.genero = genero;
	        this.idade = idade;
	        this.popularidade = popularidade;
	    }


		public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getGenero() {
	        return genero;
	    }

	    public void setGenero(String genero) {
	        this.genero = genero;
	    }

	    public String getIdade() {
	        return idade;
	    }

	    public void setIdade(String idade) {
	        this.idade = idade;
	    }

	    public double getPopularidade() {
	        return popularidade;
	    }

	    public void setPopularidade(Double popularidade) {
	        this.popularidade = popularidade;
	    }
	    
	    @Override
	    public String toString() {
	        return "Filme{" +
	               "nome='" + nome + '\'' +
	               ", genero='" + genero + '\'' +
	               ", idade='" + idade + '\'' +
	               ", popularidade=" + popularidade +
	               '}';
	    }

	}

