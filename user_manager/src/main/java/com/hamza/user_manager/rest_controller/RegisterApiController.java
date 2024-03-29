package com.hamza.user_manager.rest_controller;

import com.hamza.user_manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegisterApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<String> registerNewUser(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name, @RequestParam("email") String email, @RequestParam("password") String password) {
        // Check if any of the required fields are missing
        if(first_name == null || last_name == null || email == null || password == null) {
            return ResponseEntity.badRequest().body("Please provide all the required fields");
        } else {
            // Hash the password
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            // Register the new user
            int result = userService.registerNewUser(first_name, last_name, email, hashedPassword);
            if (result == 1) {
                return ResponseEntity.ok("User registered successfully");
            } else {
                return ResponseEntity.badRequest().body("User registration failed");
            }
        }
    }
}
