package com.amigoscode.controller;

import com.amigoscode.user.User;
import com.amigoscode.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;
    private UserController(UserService userService) { this.userService = userService; }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(
                users
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User is not found"));

        return ResponseEntity.ok(
                user
        );
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        userService.save(user)
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User _user = userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User is not found"));
        _user.setFullname(user.getFullname());
        _user.setEmail(user.getEmail());
        _user.setNohandphone(user.getNohandphone());

        return ResponseEntity.status(HttpStatus.OK).body(
                userService.save(_user)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllUser() {
        userService.deleteAll();

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}