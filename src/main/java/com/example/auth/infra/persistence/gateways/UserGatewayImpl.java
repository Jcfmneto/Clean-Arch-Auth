package com.example.auth.infra.persistence.gateways;

import com.example.auth.core.domain.entities.user.User;
import com.example.auth.core.gateway.UserGateway;
import com.example.auth.infra.persistence.entity.UserEntity;
import com.example.auth.infra.persistence.mapper.UserMapper;
import com.example.auth.infra.persistence.repository.UserRepository;

public class UserGatewayImpl implements UserGateway {

    private final UserRepository repository;

    private final UserMapper userMapper;

    public UserGatewayImpl(UserRepository repository, UserMapper userMapper){
        this.repository = repository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        repository.save(userEntity);
        return userMapper.toDomain(userEntity);
    }
}
