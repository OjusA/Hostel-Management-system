package com.hostel.controller;

import com.hostel.model.User;
import com.hostel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserRepository users;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        User user = users.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("message", "Welcome, " + username + "!");
            return "index";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
