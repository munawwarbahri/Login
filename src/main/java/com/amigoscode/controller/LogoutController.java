package com.amigoscode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LogoutController {
        @PostMapping("/logout")
        public String logout() {
           return "Silahkan Login Kembali";
        }
}