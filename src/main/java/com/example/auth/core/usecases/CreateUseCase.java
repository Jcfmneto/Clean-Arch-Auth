package com.example.auth.core.usecases;


import com.example.auth.core.domain.entities.user.User;


public interface CreateUseCase {

    User execute(User user);
}
