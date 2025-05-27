package com.example.auth.core.gateway;

public interface PasswordEncoderGateway {

    String encode(String senha);

    boolean validate(String senha, String senhaCriptografada);
}
