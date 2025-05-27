package com.example.auth.core.domain.entities.user;

import com.example.auth.core.domain.entities.user.exceptions.EmailInvalidoException;
import com.example.auth.core.domain.entities.user.exceptions.NomeInvalidoException;
import com.example.auth.core.domain.entities.user.exceptions.SenhaInvalidaException;

public class User {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private Long id;

    private String email;

    private String nome;

    private String senha;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public User(String email, String nome, String senha){

        if(email == null || !email.matches(EMAIL_REGEX)){
            throw new EmailInvalidoException(email);
        }

        if (senha == null || senha.length() < 6){
            throw new SenhaInvalidaException(senha);
        }

        if (nome.isBlank()){
            throw new NomeInvalidoException(nome);
        }

        this.email  = email;
        this.nome = nome;
        this.senha = senha;
    }
}
