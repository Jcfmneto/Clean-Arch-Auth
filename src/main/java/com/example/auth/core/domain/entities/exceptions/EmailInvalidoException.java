package com.example.auth.core.domain.entities.exceptions;

public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String email) {
        super("Email inválido: " + email);
    }
}
