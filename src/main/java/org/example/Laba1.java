package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Laba1 {

    @GetMapping("/ping")
    public Map<String, String> ping() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "pong");
        response.put("server", "running");
        return response;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Hello World!");
        response.put("server", "running");
        return response;
    }

    public static void main(String[] args) {
        SpringApplication.run(Laba1.class, args);
    }
}