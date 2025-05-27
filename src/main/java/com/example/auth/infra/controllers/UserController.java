package com.example.auth.infra.controllers;


import com.example.auth.core.usecases.users.CreateUserUseCaseImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final CreateUserUseCaseImpl createUserUseCase;

    public UserController(CreateUserUseCaseImpl createUserUseCase){
        this.createUserUseCase = createUserUseCase;
    }



    @PostMapping
    public ResponseEntity salvar()
}
