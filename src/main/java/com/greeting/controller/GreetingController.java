package com.greeting.controller;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/addgreeting")
    public Greeting addGreeting(@RequestParam(value = "fName", defaultValue = "World") String firstName,
                                @RequestParam(value = "lName", defaultValue = "World") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @RequestMapping("/getallgreeting")
    public List<Greeting> getAllGreeting() {
        return greetingService.getAllGreetings();
    }

    @PostMapping("/getgreetingbyid")
    public Greeting getGreetingById(@RequestParam(value = "id") long id) {
        return greetingService.getGreetingsById(id);
    }

    @PutMapping("/updategreetingbyid/{id}")
    public Greeting updateGreetingById(@PathVariable long id,@RequestBody User user) {
        return greetingService.updateGreetingsById(id, user);
    }

    @PostMapping("/deletegreetingbyid/{id}")
    public Greeting deleteGreetingById(@PathVariable long id) {
       return greetingService.deleteGreetingsById(id);
    }
}
