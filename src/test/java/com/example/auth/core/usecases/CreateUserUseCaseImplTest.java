package com.example.auth.core.usecases;
import com.example.auth.core.domain.entities.user.User;
import com.example.auth.core.gateway.PasswordEncoderGateway;
import com.example.auth.core.gateway.UserGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseImplTest {

    @Mock
    private UserGateway userGateway;

    @Mock
    private PasswordEncoderGateway passwordEncoder;

    @InjectMocks
    private CreateUserUseCaseImpl createUserUseCase;

    @Test
    void deveCriarUsuarioComSenhaEncriptada() {
        User userRequest = new User("email@example.com", "Nome", "senha123");

        Mockito.when(passwordEncoder.encode("senha123")).thenReturn("senhaEncriptada");

        User userToSave = new User("email@example.com", "Nome", "senhaEncriptada");

        Mockito.when(userGateway.save(Mockito.any(User.class))).thenReturn(userToSave);

        User createdUser = createUserUseCase.execute(userRequest);

        assertEquals("email@example.com", createdUser.getEmail());
        assertEquals("Nome", createdUser.getNome());
        assertEquals("senhaEncriptada", createdUser.getSenha());
    }
    @Test
    void deveLancarExcecaoQuandoFalharAoEncriptarSenha() {
        User userRequest = new User("email@example.com", "Nome", "senha123");

        Mockito.when(passwordEncoder.encode("senha123"))
                .thenThrow(new RuntimeException("Falha ao encriptar senha"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            createUserUseCase.execute(userRequest);
        });

        assertEquals("Falha ao encriptar senha", exception.getMessage());
    }

}

