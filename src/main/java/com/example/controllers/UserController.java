package com.example.controllers;

import com.example.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "user/user";
    }

}