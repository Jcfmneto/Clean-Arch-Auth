package com.example.auth.infra.security;

import com.example.auth.core.gateway.TokenProviderGateway;
import com.example.auth.core.gateway.UserGateway;
import com.example.auth.infra.persistence.entity.UserEntity;
import com.example.auth.infra.persistence.mapper.UserMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final TokenProviderGateway tokenProviderGateway;

    private final UserGateway userGateway;


    public JwtFilter(TokenProviderGateway tokenProviderGateway, UserGateway userGateway, UserMapper userMapper) {
        this.tokenProviderGateway = tokenProviderGateway;
        this.userGateway = userGateway;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recuperatoken(request);

        if (token != null) {
            var subject = tokenProviderGateway.verifyToken(token);
            userGateway.findByEmail(subject).ifPresent(user -> {
                var principal = new UserPrincipal(user);
                var auth = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            });
        }
        filterChain.doFilter(request, response);
    }

    private String recuperatoken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return  null;
    }

    }


