package com.example.auth.core.gateway;

public interface TokenProviderGateway {

    String createToken(String username);

    String verifyToken(String token);
}
