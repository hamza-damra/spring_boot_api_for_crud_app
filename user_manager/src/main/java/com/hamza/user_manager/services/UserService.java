package com.hamza.user_manager.services;

import com.hamza.user_manager.models.User;
import com.hamza.user_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int registerNewUser(String first_name, String last_name, String email, String password) {
        return userRepository.registerNewUser(first_name, last_name, email, password);
    }

    // Check if the email already exists
    public String checkUserEmail(String email) {
        return userRepository.checkUserEmail(email);
    }

   // Check User Password By Email
    public String checkUserPasswordByEmail(String email) {
        return userRepository.checkUserPasswordByEmail(email);
    }
    // Get User Details By Email
    public User getUserDetailsByEmail(String email) {
        return userRepository.getUserDetailsByEmail(email);
    }

}
