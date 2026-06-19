package org.sopt.board.global.health;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardHealthController {

    @GetMapping("/api/posts/health")
    public String health() {
        return "board-service OK";
    }
}