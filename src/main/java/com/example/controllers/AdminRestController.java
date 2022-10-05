package com.example.controllers;

import com.example.models.Role;
import com.example.models.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdminRestController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping()
    public ResponseEntity<List<User>> showAdminPage() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> oneUser(@PathVariable("id") Long id) {
      //  userService.getUserById(id);
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/patch")
    public ResponseEntity<Void> updateUser(@Valid @RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }


    @GetMapping("/header")
    public ResponseEntity<User> getAuthentication(Principal principal) {
        User user = userService.getUserByName(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
