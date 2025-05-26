package com.example.auth.core.usecases.users;
import com.example.auth.core.domain.entities.user.User;
import com.example.auth.core.gateway.PasswordEncoderGateway;
import com.example.auth.core.gateway.UserRepository;


public class CreateUseCaseImpl implements CreateUseCase{

    private final UserRepository userRepository;

    private final PasswordEncoderGateway passwordEncoder;


    public CreateUseCaseImpl(UserRepository userRepository, PasswordEncoderGateway passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User execute(User userRequest) {
        String senhaEncriptada = passwordEncoder.encode(userRequest.getSenha());
        User user = new User(userRequest.getEmail(), userRequest.getNome(), senhaEncriptada);
        return userRepository.save(user);
    }
}
