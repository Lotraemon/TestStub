package org.example.teststub.controller;

import jakarta.validation.Valid;
import org.example.teststub.dbWorker.DataBaseWorker;
import org.example.teststub.dto.User;
import org.example.teststub.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final DataBaseWorker dbWorker;
    public ApiController(DataBaseWorker dbWorker) {
        this.dbWorker = dbWorker;
    }

    @GetMapping("/users/{login}")
    public ResponseEntity<User> getUser(@PathVariable String login) {
        User user = dbWorker.getUserByLogin(login);
        if (user == null) {
            throw new UserNotFoundException("User '" + login + "' not found");
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        user.setDate(LocalDateTime.now());
        int rows = dbWorker.insertUser(user);
        return ResponseEntity.ok(rows + " rows inserted");
    }

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
                .status(HttpStatus.OK)
                .body(new User(user.getLogin(), user.getPassword(), user.getEmail(), user.getDate()));

    }
}
