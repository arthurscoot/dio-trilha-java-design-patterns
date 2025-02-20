package com.arthur_moreira.projeto.exception;

public class ListaVaziaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ListaVaziaException(String message) {
        super(message);
    }
}