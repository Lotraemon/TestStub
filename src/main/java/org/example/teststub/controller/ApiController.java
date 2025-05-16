package org.example.teststub.controller;

import jakarta.validation.Valid;
import org.example.teststub.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {

    Random rand = new Random();

    private void getRandomDelay() {
        try {
            Thread.sleep(rand.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("RandomDelay was interrupted", e);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        getRandomDelay();
        return ResponseEntity.ok("{\"login\":\"Login1\",\"status\":\"ok\"}");
    }


    @PostMapping("/post")
    public ResponseEntity<User> post(@RequestBody @Valid User user) {
        getRandomDelay();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new User(user.getLogin(), user.getPassword()));

    }
}
