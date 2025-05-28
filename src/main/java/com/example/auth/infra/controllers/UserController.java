package com.example.auth.infra.controllers;


import com.example.auth.core.domain.entities.user.User;
import com.example.auth.core.usecases.CreateUserUseCaseImpl;
import com.example.auth.core.usecases.LoginUseCaseImpl;
import com.example.auth.infra.controllers.dto.request.LoginDTO;
import com.example.auth.infra.controllers.dto.response.TokenResponse;
import com.example.auth.infra.controllers.dto.request.RegisterDto;
import com.example.auth.infra.controllers.dto.mappers.UserDtoMapper;
import com.example.auth.infra.controllers.dto.response.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<UserResponseDto> register(@RequestBody @Valid RegisterDto dto){
       User user = userDtoMapper.registerToDomain(dto);
       User salvo = createUser.execute(user);
       UserResponseDto resposta = userDtoMapper.userToResponse(salvo);
       return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginDTO dto){
        User user = userDtoMapper.loginToDomain(dto);
        String resposta = login.execute(user);
        return ResponseEntity.ok(new TokenResponse(resposta));
    }

}
