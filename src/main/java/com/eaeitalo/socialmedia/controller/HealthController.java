package com.eaeitalo.socialmedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Health Controller - Endpoints de health check
 * @author @eaeitalo
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "service", "Social Media API",
                "developer", "@eaeitalo",
                "message", "API rodando com sucesso!"
        );
    }

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
                "message", "Bem-vindo à Social Media API",
                "developer", "@eaeitalo",
                "endpoints", "/api/users, /api/posts, /health",
                "version", "1.0.0"
        );
    }
}
