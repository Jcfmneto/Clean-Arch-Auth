package com.example.auth.core.domain.entities.exceptions;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException(String senha) {
        super("Insira uma senha válida");
    }
}
