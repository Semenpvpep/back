package com.tsaplev.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

import com.tsaplev.backend.entities.User;
import com.tsaplev.backend.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
        Authentication authenticationRequest =
            UsernamePasswordAuthenticationToken.unauthenticated(user.getUsername(), user.getPassword());
        Authentication authenticationResponse =
			authenticationManager.authenticate(authenticationRequest);
        SecurityContextHolder.getContext().setAuthentication(authenticationResponse);
        return ResponseEntity.ok(userService.loginUser(user));
    }
}
