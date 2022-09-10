package com.example.service;

import com.example.dao.RoleDao;
import com.example.models.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceimp implements RoleService {

    private final RoleDao roleDao;
    public RoleServiceimp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public void addRole(Role role) {
        roleDao.saveRole(role);
    }
    @Override
    public Set<Role> findRollsbyId(String roleId) {
        Set<Role> roles = new HashSet<>();
        for (Role role : getAllRoles()){
            if (roleId.contains(role.getId().toString())) {
                roles.add(role);
            }
        }
        return roles;
    }
    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
