package com.estudosjavaspring.springcourse.resources;

import com.estudosjavaspring.springcourse.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User usr = new User(1L, "Pablo Marcelo", "pabloa@gmail.com", "6199843123", "1234");
        return ResponseEntity.ok().body(usr);
    }
}
