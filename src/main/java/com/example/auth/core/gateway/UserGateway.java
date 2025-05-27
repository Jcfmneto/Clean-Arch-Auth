package com.example.auth.core.gateway;

import com.example.auth.core.domain.entities.User;

public interface UserGateway {

   User save(User user);
}
