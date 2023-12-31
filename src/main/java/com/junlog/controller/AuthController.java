package com.junlog.controller;

import com.junlog.request.Login;
import com.junlog.response.SessionResponse;
import com.junlog.service.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Base64;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private static final String KEY = "ij7wsgLb2owy3YV/h82T9EeNt9MYGNSDDnUa/vlAqmA=";
    private final AuthService authService;

    @PostMapping("/auth/login")
    public SessionResponse login(@RequestBody Login login){
        Long userId = authService.signin(login);

        SecretKey key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(KEY));

        String jws = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .signWith(key)
                .compact();

        return new SessionResponse(jws);
    }
}
