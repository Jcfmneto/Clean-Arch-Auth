package com.example.auth.core.domain.entities.exceptions;

public class NomeInvalidoException extends RuntimeException {
    public NomeInvalidoException(String nome) {
        super("Nome não pode estar vazio");
    }
}
