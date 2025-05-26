package com.example.auth.core.gateway;

import com.example.auth.core.domain.entities.user.User;

public interface UserRepository {

   User save(User user);
}
