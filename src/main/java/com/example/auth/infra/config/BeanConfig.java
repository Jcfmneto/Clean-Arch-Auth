package com.example.auth.infra.config;


import com.example.auth.core.gateway.PasswordEncoderGateway;
import com.example.auth.core.gateway.UserGateway;
import com.example.auth.core.usecases.CreateUserUseCaseImpl;
import com.example.auth.core.usecases.LoginUseCaseImpl;
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
   UserMapper userMapper() {
       return new UserMapper();
   }

   @Bean
    LoginUseCaseImpl loginUseCase(UserGateway userGateway, PasswordEncoderGateway passwordEncoder) {
       return new LoginUseCaseImpl(userGateway, passwordEncoder);
   }

   @Bean(name = "Bean PasswordGatewayImpl")
   PasswordEncoderGatewayImpl passwordEncoder(PasswordEncoder passwordEncoder) {
       return new PasswordEncoderGatewayImpl(passwordEncoder);
   }

   @Bean
   UserDtoMapper  userDtoMapper() {
       return new UserDtoMapper();
   }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserMapper userMapper) {
        return new UserGatewayImpl(userRepository, userMapper);
    }


    @Bean
    CreateUserUseCaseImpl createUserUseCaseImpl(UserGateway userRepository, PasswordEncoderGateway passwordEncoder) {
        return new CreateUserUseCaseImpl(userRepository, passwordEncoder);
    }
}
