package com.example.auth.infra.persistence.mapper;

import com.example.auth.core.domain.entities.User;
import com.example.auth.infra.persistence.entity.UserEntity;

public class UserMapper {

    public UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setNome(user.getNome());
        userEntity.setSenha(user.getSenha());
        return userEntity;
    }

    public User toDomain(UserEntity userEntity){
        User user = new User();
        user.setEmail(userEntity.getEmail());
        user.setNome(userEntity.getNome());
        user.setSenha(userEntity.getSenha());
        return user;
    }
}
