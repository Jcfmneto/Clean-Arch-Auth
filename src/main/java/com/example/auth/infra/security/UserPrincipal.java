package com.example.auth.infra.security;
import com.example.auth.core.domain.entities.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

   private final User user;

   public UserPrincipal(User user) {
       this.user = user;
   }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getSenha();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
}