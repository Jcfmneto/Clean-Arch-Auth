package com.example.auth.core.usecases;

import com.example.auth.core.domain.entities.exceptions.EmailNaoEncontradoException;
import com.example.auth.core.domain.entities.exceptions.SenhaInvalidaException;
import com.example.auth.core.domain.entities.user.User;
import com.example.auth.core.gateway.PasswordEncoderGateway;
import com.example.auth.core.gateway.TokenProviderGateway;
import com.example.auth.core.gateway.UserGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LoginUseCaseImplTest {

    @Mock
    private UserGateway userGateway;

    @Mock
    private PasswordEncoderGateway passwordEncoderGateway;

    @Mock
    private TokenProviderGateway tokenProviderGateway;

    @InjectMocks
    private LoginUseCaseImpl loginUseCase;

    @Test
    void deveRetornarTokenQuandoCredenciaisForemValidas() {
        User loginUser = new User("email@example.com", "Nome", "123456");
        User storedUser = new User("email@example.com", "Nome", "senhaEncriptada");

        Mockito.when(userGateway.findByEmail("email@example.com")).thenReturn(Optional.of(storedUser));
        Mockito.when(passwordEncoderGateway.validate("123456", "senhaEncriptada")).thenReturn(true);
        Mockito.when(tokenProviderGateway.createToken("email@example.com")).thenReturn("token-jwt");

        String token = loginUseCase.execute(loginUser);

        assertEquals("token-jwt", token);
    }

    @Test
    void deveLancarExcecaoQuandoEmailNaoForEncontrado() {
        User loginUser = new User("inexistente@example.com", "Nome", "123456");

        Mockito.when(userGateway.findByEmail("inexistente@example.com")).thenReturn(Optional.empty());

        assertThrows(EmailNaoEncontradoException.class, () -> loginUseCase.execute(loginUser));
    }

    @Test
    void deveLancarExcecaoQuandoSenhaForInvalida() {
        User loginUser = new User("email@example.com", "Nome", "senhaIncorreta");
        User storedUser = new User("email@example.com", "Nome", "senhaEncriptada");

        Mockito.when(userGateway.findByEmail("email@example.com")).thenReturn(Optional.of(storedUser));
        Mockito.when(passwordEncoderGateway.validate("senhaIncorreta", "senhaEncriptada")).thenReturn(false);

        assertThrows(SenhaInvalidaException.class, () -> loginUseCase.execute(loginUser));
    }
}

