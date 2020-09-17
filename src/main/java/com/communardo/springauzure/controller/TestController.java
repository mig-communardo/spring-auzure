package com.communardo.springauzure.controller;

import com.communardo.springauzure.controller.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.*;

@RestController
public class TestController {


    public static List<User> users = Arrays.asList(new User(1, "Mirjan"), new User(2, "Paula"));

    @GetMapping("/")
    public String welcome (){
        return "welcome";
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        Optional<User> user = users.stream().filter(usr -> usr.getId() == id).findFirst();
        return ResponseEntity.of(user);
    }
    /* push to master */
}
