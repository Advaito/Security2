package com.example.service;


import com.example.dao.UserDao;
import com.example.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceimp implements UserService {

    private final UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}