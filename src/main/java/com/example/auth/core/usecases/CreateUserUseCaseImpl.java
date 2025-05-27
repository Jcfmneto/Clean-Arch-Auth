package com.example.auth.core.usecases;
import com.example.auth.core.domain.entities.User;
import com.example.auth.core.gateway.PasswordEncoderGateway;
import com.example.auth.core.gateway.UserGateway;


public class CreateUserUseCaseImpl implements CreateUseCase{

    private final UserGateway userGateway;

    private final PasswordEncoderGateway passwordEncoder;


    public CreateUserUseCaseImpl(UserGateway userGateway, PasswordEncoderGateway passwordEncoder) {
        this.userGateway = userGateway;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User execute(User userRequest) {
        String senhaEncriptada = passwordEncoder.encode(userRequest.getSenha());
        User user = new User(userRequest.getEmail(), userRequest.getNome(), senhaEncriptada);
        return userGateway.save(user);
    }
}
