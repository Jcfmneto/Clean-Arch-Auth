package com.example.auth.infra.controllers.dto.mappers;

import com.example.auth.core.domain.entities.user.User;
import com.example.auth.infra.controllers.dto.request.LoginDTO;
import com.example.auth.infra.controllers.dto.request.RegisterDto;
import com.example.auth.infra.controllers.dto.response.UserResponseDto;

public class UserDtoMapper {

    public User registerToDomain(RegisterDto dto){
        return new User(dto.email(), dto.nome(), dto.senha());
    }

    public User loginToDomain(LoginDTO dto){
        return new User(dto.email(), dto.senha());
    }

    public UserResponseDto userToResponse(User user){
        return new UserResponseDto(user.getEmail(), user.getNome());
    }
}
