package com.learning.restfulwebservices.controller;

import com.learning.restfulwebservices.model.User;
import com.learning.restfulwebservices.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/api/v1/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/api/v1/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping(path = "/api/v1/users")
    public ResponseEntity<URI> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                             .buildAndExpand(savedUser.getId())
                                             .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/api/v1/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        User deletedUser = userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
