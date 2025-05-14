package org.example.teststub;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {

    Random rand = new Random();
    private int getRandomDelay(){
        return  rand.nextInt(1000) + 1000;}

    @GetMapping("/get")
    /* public String get() {
        return "{\"login\":\"Login1\",\"status\":\"ok\"}"; //экранировать
    }*/

    public GetResponse get() throws InterruptedException {
        Thread.sleep(getRandomDelay());
        return new GetResponse();
    }

    @PostMapping("/post")
    public PostResponse post(@RequestBody PostRequest postRequest) throws InterruptedException {
        Thread.sleep(getRandomDelay());
        return new PostResponse(postRequest.getLogin(), postRequest.getPassword());
    }
}
