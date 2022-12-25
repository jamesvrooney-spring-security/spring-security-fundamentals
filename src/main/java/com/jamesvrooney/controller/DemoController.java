package com.jamesvrooney.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class DemoController {

    @GetMapping("hello")
    public String hello(Authentication authentication) {
        log.info("Hitting /hello endpoint.");

        final String name = authentication.getName();

        final String greeting = "Hello " + name;

        return greeting;
    }
}
