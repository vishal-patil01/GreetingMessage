package com.greeting.service.implementation;

import com.greeting.exceptions.GreetingException;
import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.repository.IGreetingRepository;
import com.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private final AtomicLong counter = new AtomicLong();
    private Greeting greeting;

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = user.toString().isEmpty() ? "Hello World" :
                "Hello " + user.getFirstName() + " " + user.getLastName();
        greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getGreetingsById(long id) {
        return greetingRepository.findById(id).
                orElseThrow(() -> new GreetingException("No Record Found", GreetingException.ExceptionTypes.NO_RECORD_FOUND));
    }

    @Override
    public Greeting updateGreetingsById(long id, User user) {
        greeting = getGreetingsById(id);
        greeting.setMessage("Hello " + user.getFirstName() + " " + user.getLastName());
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting deleteGreetingsById(long id) {
        greeting = getGreetingsById(id);
        greetingRepository.delete(greeting);
        return greeting;
    }
}
