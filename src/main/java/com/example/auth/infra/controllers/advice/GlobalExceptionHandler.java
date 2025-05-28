package com.example.auth.infra.controllers.advice;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.auth.core.domain.entities.exceptions.EmailInvalidoException;
import com.example.auth.core.domain.entities.exceptions.EmailNaoEncontradoException;
import com.example.auth.core.domain.entities.exceptions.NomeInvalidoException;
import com.example.auth.core.domain.entities.exceptions.SenhaInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailInvalidoException.class)
    public ResponseEntity<ErrorResponse> handleEmailInvalidoException(EmailInvalidoException exception, HttpStatus status) {
        return buildResponse(exception, status);
    }

    @ExceptionHandler(EmailNaoEncontradoException.class)
    public ResponseEntity<ErrorResponse> handleEmailNaoEncontradoException(EmailNaoEncontradoException exception, HttpStatus status) {
        return buildResponse(exception, status);
    }

    @ExceptionHandler(NomeInvalidoException.class)
    public ResponseEntity<ErrorResponse> handleNomeInvalidoException(NomeInvalidoException exception, HttpStatus status) {
        return buildResponse(exception, status);
    }
    @ExceptionHandler(SenhaInvalidaException.class)
    public ResponseEntity<ErrorResponse> handleSenhaInvalidaException(SenhaInvalidaException exception, HttpStatus status) {
        return buildResponse(exception, status);
    }

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<ErrorResponse> handleJWTCreationException(JWTCreationException exception, HttpStatus status) {
        return buildResponse(exception, status);
    }

    @ExceptionHandler(JWTDecodeException.class)
    public ResponseEntity<ErrorResponse> handleJWTDecodeException(JWTDecodeException exception, HttpStatus status) {
        return buildResponse(exception, status);
    }

    private ResponseEntity<ErrorResponse> buildResponse(Exception ex, HttpStatus status) {
        ErrorResponse error = new  ErrorResponse(ex.getMessage(), ex.getClass().getSimpleName(), status.value(), LocalDateTime.now());
        return ResponseEntity.status(status).body(error);
    }

}
