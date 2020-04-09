package com.greetingmessage.greeting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello , %s !";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/post/greeting")
    public Greeting greeting(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(), String.format(template, greeting.getFormat()));
    }

    @PutMapping("/put/greeting")
    public ResponseEntity<Greeting> putGreeting(@RequestBody Greeting greeting) {
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
