package com.example.auth.infra.controllers.advice;

import java.time.LocalDateTime;

public record ErrorResponse(

        String message,

        String error,

        int statusCode,

        LocalDateTime timestamp
) {
}
