package com.jamesvrooney.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("hello")
    public String hello(Authentication authentication) {
        final String name = authentication.getName();

        final String greeting = "Hello " + name;

        return greeting;
    }
}
