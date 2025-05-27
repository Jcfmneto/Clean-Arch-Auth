package com.example.auth.infra.controllers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record LoginDTO(

        @Email
        String email,

        @Size(min = 6)
        String senha
) {
}
