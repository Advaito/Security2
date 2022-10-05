package com.example.service;

import com.example.dao.RoleDao;
import com.example.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceimp implements RoleService {

    private final RoleDao roleDao;

    @Override
    @Transactional
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
    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    public Role getRole(String name) {
        return roleDao.getRole(name);
    }
}
