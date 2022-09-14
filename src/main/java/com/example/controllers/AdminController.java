package com.example.controllers;

import com.example.models.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getAllUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/adminPage";
    }

    @GetMapping("/add")
    public String newUserPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/newUser";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") @Valid User user) {
        getUserRoles(user);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PutMapping("/{id}/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        getUserRoles(user);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
    private void getUserRoles(User user) {
        user.setRoles(user.getRoles().stream()
                .map(role -> roleService.getRole(role.getName()))
                .collect(Collectors.toSet()));
    }

}
