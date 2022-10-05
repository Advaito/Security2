package com.example.controllers;

import com.example.models.User;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping("/principal")
    public ResponseEntity<User> showUser(Principal principal) {
        return new ResponseEntity<>(userService.getUserByName(principal.getName()), HttpStatus.OK);
    }
}