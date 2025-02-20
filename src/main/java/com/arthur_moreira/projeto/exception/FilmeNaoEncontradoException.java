package com.arthur_moreira.projeto.exception;

public class FilmeNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FilmeNaoEncontradoException(String message) {
        super(message);
    }
}