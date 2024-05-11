package com.tsaplev.backend.services;

import com.tsaplev.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import com.tsaplev.backend.entities.User;

import lombok.AllArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        Optional<User> opUser = userRepository.findByUsername(user.getUsername());
        if (opUser.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities("USER");
        userRepository.save(user);
    }

    public Map<String, String> loginUser(User user) {
        Optional<User> opUser = userRepository.findByUsername(user.getUsername());

        if (!opUser.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        if (!passwordEncoder.matches(user.getPassword(), opUser.get().getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        Map<String, String> keyValue = new HashMap<>();

        keyValue.put("userId", Long.toString(opUser.get().getId()));
        keyValue.put("username", opUser.get().getUsername());

        String usernamePassword = user.getUsername() + ":" + user.getPassword();
        System.out.println(usernamePassword);
        String encodedUsernamePassword = Base64.getEncoder().encodeToString(usernamePassword.getBytes(StandardCharsets.UTF_8));

        keyValue.put("authToken", encodedUsernamePassword);

        return keyValue;
    }
}
