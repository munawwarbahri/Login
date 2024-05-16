package com.amigoscode.controller;

import com.amigoscode.repository.UserRepository;
import com.amigoscode.service.UserService;
import com.amigoscode.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
@RequestMapping("/api/v1/user/login")
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (user.getEmail().equals("email") && user.getPassword().equals("password")) {
            return "Login berhasil";
        } else {
            return "Login gagal";
        }
    }

}

