package com.jamesvrooney.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("hello")
    public String hello() {
        final String greeting = "Hello James";

        return greeting;
    }
}
