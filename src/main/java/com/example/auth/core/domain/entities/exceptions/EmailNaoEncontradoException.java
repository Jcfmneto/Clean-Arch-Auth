package com.example.auth.core.domain.entities.exceptions;

public class EmailNaoEncontradoException extends RuntimeException {
    public EmailNaoEncontradoException(String userNotFound) {
        super("Email não encontrado" + userNotFound);
    }
}
