package com.tsaplev.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PingController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/securePing") 
    public String securePing() {
        return "pong";
    }
}
