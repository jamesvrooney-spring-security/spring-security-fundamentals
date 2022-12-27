package com.jamesvrooney.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class DemoController {

    @GetMapping("demo")
    @PreAuthorize("hasAuthority('read')")
    public String demo(Authentication authentication) {
        log.info("Hitting /demo endpoint.");

        final String greeting = "Demo " + authentication.getName();

        return greeting;
    }

    @GetMapping("hello")
    public String hello(Authentication authentication) {
        log.info("Hitting /hello endpoint.");

        final String greeting = "Hello " + authentication.getName();

        return greeting;
    }
}
