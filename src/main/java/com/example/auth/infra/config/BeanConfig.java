package com.example.auth.infra.config;


import com.example.auth.core.gateway.PasswordEncoderGateway;
import com.example.auth.core.gateway.TokenProviderGateway;
import com.example.auth.core.gateway.UserGateway;
import com.example.auth.core.usecases.CreateUserUseCaseImpl;
import com.example.auth.core.usecases.LoginUseCaseImpl;
import com.example.auth.infra.controllers.dto.mappers.UserDtoMapper;
import com.example.auth.infra.security.PasswordEncoderGatewayImpl;
import com.example.auth.infra.persistence.gateways.UserGatewayImpl;
import com.example.auth.infra.persistence.mapper.UserMapper;
import com.example.auth.infra.persistence.repository.UserRepository;
import com.example.auth.infra.security.TokenProviderGatewayImpl;
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
   TokenProviderGateway tokenProviderGateway() {
       return new TokenProviderGatewayImpl();
   }


   @Bean
    LoginUseCaseImpl loginUseCase(UserGateway userGateway, PasswordEncoderGateway passwordEncoder, TokenProviderGateway tokenProviderGateway) {
       return new LoginUseCaseImpl(userGateway, passwordEncoder, tokenProviderGateway);
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
