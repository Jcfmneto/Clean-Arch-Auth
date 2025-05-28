package com.example.auth.infra.controllers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterDto(

        @Email
        String email,

        @NotBlank
        String nome,

        @NotBlank
        @Size(min = 6)
        String senha) {
}
