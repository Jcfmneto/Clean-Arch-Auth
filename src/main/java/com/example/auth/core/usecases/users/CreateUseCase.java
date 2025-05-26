package com.example.auth.core.usecases.users;


import com.example.auth.core.domain.entities.user.User;


public interface CreateUseCase {

    User execute(User user);
}
