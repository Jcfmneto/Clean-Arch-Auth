package com.example.auth.infra.config;


import com.example.auth.core.gateway.PasswordEncoderGateway;
import com.example.auth.core.gateway.UserGateway;
import com.example.auth.core.usecases.CreateUserUseCaseImpl;
import com.example.auth.infra.controllers.dto.UserDtoMapper;
import com.example.auth.infra.persistence.gateways.PasswordEncoderGatewayImpl;
import com.example.auth.infra.persistence.gateways.UserGatewayImpl;
import com.example.auth.infra.persistence.mapper.UserMapper;
import com.example.auth.infra.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfig {

   @Bean
   public UserMapper userMapper() {
       return new UserMapper();
   }

   @Bean(name = "Bean PasswordGatewayImpl")
   public PasswordEncoderGatewayImpl passwordEncoder(PasswordEncoder passwordEncoder) {
       return new PasswordEncoderGatewayImpl(passwordEncoder);
   }

   @Bean
   public UserDtoMapper  userDtoMapper() {
       return new UserDtoMapper();
   }

    @Bean
    public UserGateway userGateway(UserRepository userRepository, UserMapper userMapper) {
        return new UserGatewayImpl(userRepository, userMapper);
    }


    @Bean
    public CreateUserUseCaseImpl createUserUseCaseImpl(UserGateway userRepository, PasswordEncoderGateway passwordEncoder) {
        return new CreateUserUseCaseImpl(userRepository, passwordEncoder);
    }
}
