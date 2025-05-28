package org.example.teststub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LeakController {
    private final List<byte[]> memoryLeak = new ArrayList<>();

    @GetMapping("/leak")
    public String leak() {
        byte[] block = new byte[10 * 1024 * 1024];
        memoryLeak.add(block);
        return "+ 10 MB";
    }
}
