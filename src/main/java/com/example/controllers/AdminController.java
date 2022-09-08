package com.example.controllers;

import com.example.models.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }


    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.findAll());
        return "admin/new";
    }

    @PostMapping
    public String createUser(@RequestParam("roles") int[] roleId,
                             @ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/new";
        }
        user.setRoles(roleService.findById(roleId));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("allRoles", roleService.findAll());
        model.addAttribute("user", userService.getUserById(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@RequestParam("roles") int[] roleId, @ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "admin/edit";
        }
        user.setRoles(roleService.findById(roleId));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
