package com.example.dao;

import com.example.models.Role;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Component
public class RoleDaoimp implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public List<Role> getAllRoles() {
        TypedQuery<Role> query = entityManager.createQuery("select r from Role r", Role.class);
        return query.getResultList();
    }
    @Transactional
    public void saveRole(Role role) {
        entityManager.persist(role);
    }
}
