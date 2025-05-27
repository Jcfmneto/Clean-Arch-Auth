package com.example.auth.infra.controllers;


import com.example.auth.core.domain.entities.user.User;
import com.example.auth.core.usecases.CreateUserUseCaseImpl;
import com.example.auth.core.usecases.LoginUseCaseImpl;
import com.example.auth.infra.controllers.dto.LoginDTO;
import com.example.auth.infra.controllers.dto.UserDTO;
import com.example.auth.infra.controllers.dto.UserDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final CreateUserUseCaseImpl createUser;

    private final LoginUseCaseImpl login;

    private final UserDtoMapper userDtoMapper;

    public UserController(CreateUserUseCaseImpl createUser, LoginUseCaseImpl login,  UserDtoMapper userDtoMapper) {
        this.createUser = createUser;
        this.userDtoMapper = userDtoMapper;
        this.login = login;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO dto){
       User user = userDtoMapper.toDomain(dto);
       User salvo = createUser.execute(user);
       UserDTO resposta = userDtoMapper.toDto(salvo);
       return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PostMapping("/login")
    public ResponseEntity<?> updateUser(@RequestBody @Valid LoginDTO dto){
        User user = userDtoMapper.LoginToDomain(dto);
        var resposta = login.execute(user);
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

}
