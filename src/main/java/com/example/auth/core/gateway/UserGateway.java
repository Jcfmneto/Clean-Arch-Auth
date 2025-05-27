package com.example.auth.core.gateway;

import com.example.auth.core.domain.entities.user.User;

import java.util.Optional;

public interface UserGateway {

   User save(User user);

   Optional<User> findByEmail(String email);
}
