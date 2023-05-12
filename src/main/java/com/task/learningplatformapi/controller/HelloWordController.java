package com.task.learningplatformapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloWordController {

    @GetMapping(path = "/sayHello")
    public String sayHello() {
        return "hey, what's up!";
    }
}
