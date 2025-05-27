package com.example.auth.infra.persistence.gateways;

import com.example.auth.core.gateway.PasswordEncoderGateway;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGatewayImpl implements PasswordEncoderGateway {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncoderGatewayImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public String encode(String senha) {
        return passwordEncoder.encode(senha);
    }

    @Override
    public boolean validate(String senha, String senhaCriptografada) {
        return passwordEncoder.matches(senha, senhaCriptografada);
    }
}
