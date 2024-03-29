package com.hamza.user_manager.rest_controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserApiController {
    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }
}
