package com.example.dao;


import com.example.models.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDaoimp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
    }
}