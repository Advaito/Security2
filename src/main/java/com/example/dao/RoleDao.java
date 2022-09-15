package com.example.dao;


import com.example.models.Role;

import java.util.List;

public interface RoleDao {
    void saveRole(Role role);
    List<Role> getAllRoles();
    Role getRole(String name);
}