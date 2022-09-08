package com.example.service;

import com.example.models.Role;
import com.example.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceimp implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceimp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Set<Role> findAll() {
        return new HashSet<>(roleRepository.findAll());
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Set<Role> findById(int[] id) {
        return roleRepository.getRolesById(id);
    }

}
