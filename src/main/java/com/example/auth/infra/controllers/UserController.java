package com.example.auth.infra.controllers;


import com.example.auth.core.domain.entities.User;
import com.example.auth.core.usecases.CreateUserUseCaseImpl;
import com.example.auth.infra.controllers.dto.UserDTO;
import com.example.auth.infra.controllers.dto.UserDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final CreateUserUseCaseImpl createUser;

    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserUseCaseImpl createUser,  UserDtoMapper userDtoMapper) {
        this.createUser = createUser;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO dto){
       User user = userDtoMapper.toDomain(dto);
       User salvo = createUser.execute(user);
       UserDTO resposta = userDtoMapper.toDto(salvo);
       return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

}
