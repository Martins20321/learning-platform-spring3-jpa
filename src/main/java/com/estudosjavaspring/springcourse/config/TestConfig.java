package com.estudosjavaspring.springcourse.config;

import com.estudosjavaspring.springcourse.entities.User;
import com.estudosjavaspring.springcourse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User us1 = new User(null, "Pablo Marcelo", "pabloa@gmail.com", "6199843123", "1234");
        User us2 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User us3 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(us1,us2,us3));
    }
}
