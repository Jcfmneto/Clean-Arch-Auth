package com.example.auth.infra.controllers;


import com.example.auth.infra.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public ResponseEntity teste(@AuthenticationPrincipal UserPrincipal user) {
        return ResponseEntity.ok().body(user);
    }
}
