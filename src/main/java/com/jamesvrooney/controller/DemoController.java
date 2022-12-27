package com.jamesvrooney.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class DemoController {

    @GetMapping("hello")
    public String hello() {
        log.info("Hitting /hello endpoint.");

        final String greeting = "Hello James";

        return greeting;
    }
}
