package com.example.jwt.controller;

import com.example.jwt.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final JwtUtil jwtUtil;

    public AuthenticationController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Basic "))
            return ResponseEntity.status(400).body(Map.of("error", "Missing Basic auth header"));

        String base64Credentials = header.substring("Basic ".length());
        String creds = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
        String[] split = creds.split(":", 2);
        String username = split[0];

        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok(Map.of("token", token));
    }
}
