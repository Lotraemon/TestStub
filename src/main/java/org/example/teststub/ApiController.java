package org.example.teststub;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {

    Random rand = new Random();
    private final int delay = rand.nextInt(2000 - 1000 + 1) + 1000;

    @GetMapping("/get")
    /* public String get() {
        //"{"login":"Login1","status":"ok"}" нужно экранировать
        return "{\"login\":\"Login1\",\"status\":\"ok\"}";
    }*/

    public GetResponse get() throws InterruptedException {
        Thread.sleep(delay);
        return new GetResponse();
    }

    @PostMapping
    public PostResponse post(@RequestBody PostRequest postRequest) throws InterruptedException {
        Thread.sleep(delay);
        return new PostResponse(postRequest.getLogin(), postRequest.getPassword());
    }
}
