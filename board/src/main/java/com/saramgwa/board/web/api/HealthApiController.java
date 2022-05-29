package com.saramgwa.board.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthApiController {
    
    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
