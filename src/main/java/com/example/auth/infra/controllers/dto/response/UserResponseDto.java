package com.example.auth.infra.controllers.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserResponseDto(

        @Email
        String email,

        @NotBlank
        String nome) {
}
