package com.example.auth.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.auth.core.gateway.TokenProviderGateway;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TokenProviderGatewayImpl implements TokenProviderGateway {

    @Value("${JWT.SECRET}")
    private String secret;

    @Override
    public String createToken(String username) {

    try {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer("project")
                .withSubject(username)
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);
    }catch (Exception e){
        return e.getMessage();
    }

    }

    @Override
    public String verifyToken(String token) {
            try{
                Algorithm algorithm = Algorithm.HMAC256(secret);
                return JWT.require(algorithm)
                        .withIssuer("project")
                        .build()
                        .verify(token)
                        .getSubject();
            }catch (JWTVerificationException e){
                return e.getMessage();
            }
        }

   private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
   }
}
