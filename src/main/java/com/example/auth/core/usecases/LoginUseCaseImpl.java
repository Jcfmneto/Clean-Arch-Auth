package com.example.auth.core.usecases;

import com.example.auth.core.domain.entities.user.User;
import com.example.auth.core.domain.entities.exceptions.EmailNaoEncontradoException;
import com.example.auth.core.domain.entities.exceptions.SenhaInvalidaException;
import com.example.auth.core.gateway.PasswordEncoderGateway;
import com.example.auth.core.gateway.TokenProviderGateway;
import com.example.auth.core.gateway.UserGateway;


public class LoginUseCaseImpl implements LoginUseCase {

    private final UserGateway userGateway;

    private final PasswordEncoderGateway passwordEncoderGateway;

    private final TokenProviderGateway tokenProviderGateway;

    public LoginUseCaseImpl(UserGateway userGateway, PasswordEncoderGateway passwordEncoderGateway, TokenProviderGateway tokenProviderGateway) {
        this.userGateway = userGateway;
        this.passwordEncoderGateway = passwordEncoderGateway;
        this.tokenProviderGateway = tokenProviderGateway;
    }

    @Override
    public String execute(User loginUser) {
        User user = userGateway.findByEmail(loginUser.getEmail()).orElseThrow(()->new EmailNaoEncontradoException(loginUser.getEmail()));

        if(!passwordEncoderGateway.validate(loginUser.getSenha(), user.getSenha())){
            throw new SenhaInvalidaException(user.getSenha());
        }
        String token = tokenProviderGateway.createToken(loginUser.getEmail());
        return token;
    }
}
