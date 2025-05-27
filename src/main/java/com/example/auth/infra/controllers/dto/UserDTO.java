package com.example.auth.infra.controllers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(

        @Email
        String email,

        @NotBlank
        String nome,

        @NotBlank
        @Size(min = 6)
        String senha) {
}
