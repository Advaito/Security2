package com.example.service;

import com.example.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();
    void addRole(Role role);
    Set<Role> findRollsbyId(String RoleIds);
    Role getRole(String name);
}