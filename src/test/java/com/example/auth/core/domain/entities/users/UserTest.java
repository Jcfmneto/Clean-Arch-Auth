package com.example.auth.core.domain.entities.users;

import com.example.auth.core.domain.entities.exceptions.EmailInvalidoException;
import com.example.auth.core.domain.entities.exceptions.NomeInvalidoException;
import com.example.auth.core.domain.entities.exceptions.SenhaInvalidaException;
import com.example.auth.core.domain.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void deveCriarUsuarioQuandoDadosValidos() {
        User user = new User("teste@example.com", "João", "senha123");
        assertEquals("teste@example.com", user.getEmail());
        assertEquals("João", user.getNome());
        assertEquals("senha123", user.getSenha());
    }

    @Test
    void deveLancarExcecaoQuandoEmailInvalido() {
        assertThrows(EmailInvalidoException.class, () -> {
            new User("emailinvalido", "João", "senha123");
        });

        assertThrows(EmailInvalidoException.class, () -> {
            new User(null, "João", "senha123");
        });
    }

    @Test
    void deveLancarExcecaoQuandoSenhaInvalida() {

        assertThrows(SenhaInvalidaException.class, () -> {
            new User("teste@example.com", "João", "123");
        });
        assertThrows(SenhaInvalidaException.class, () -> {
            new User("teste@example.com", "João", null);
        });
    }

    @Test
    void deveLancarExcecaoQuandoNomeInvalido() {
        assertThrows(NomeInvalidoException.class, () -> {
            new User("teste@example.com", "", "senha123");
        });

        assertThrows(NomeInvalidoException.class, () -> {
            new User("teste@example.com", "   ", "senha123");
        });
    }

}