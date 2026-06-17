package org.sopt.auth.global.health;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthHealthController {

    @GetMapping("/api/auth/health")
    public String health() {
        return "board-service OK";
    }
}