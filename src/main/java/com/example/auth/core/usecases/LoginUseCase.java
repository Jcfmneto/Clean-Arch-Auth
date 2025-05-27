package com.example.auth.core.usecases;

import com.example.auth.core.domain.entities.user.User;

public interface LoginUseCase {
    String  execute(User user);
}
