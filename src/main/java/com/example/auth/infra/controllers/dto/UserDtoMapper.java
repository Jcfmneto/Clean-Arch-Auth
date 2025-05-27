package com.example.auth.infra.controllers.dto;

import com.example.auth.core.domain.entities.User;

public class UserDtoMapper {

    public User toDomain(UserDTO dto){
        return new User(dto.email(), dto.nome(), dto.senha());
    }

    public UserDTO toDto(User salvo) {
        return new UserDTO(salvo.getEmail(),  salvo.getNome(), salvo.getSenha());
    }
}
