package com.example.service;

import com.example.models.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> findAll();
    Role findByName(String name);
    void save(Role role);

    Set<Role> findById(int[] id);


}