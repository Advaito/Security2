package com.example.service;


import com.example.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String username);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}