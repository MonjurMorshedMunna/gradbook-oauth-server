package com.gradbook.controllers;

import com.gradbook.models.user.User;
import com.gradbook.models.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Munna on 25-Jun-17.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public User user(Principal user){
        User loggedUser = userRepository.findByEmail(user.getName());
        loggedUser.setPassword("");
        return loggedUser;
    }
}
