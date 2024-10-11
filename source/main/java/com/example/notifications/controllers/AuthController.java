package com.example.notifications.controllers;

import com.example.notifications.models.User;
import com.example.notifications.security.JwtTokenProvider;
import com.example.notifications.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.authenticate(email, password);
        String token = tokenProvider.generateToken(user.getId());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserDetails() {
        User user = userService.getAuthenticatedUser();
        user.setPassword(null); // Hide password
        return ResponseEntity.ok(user);
    }
}