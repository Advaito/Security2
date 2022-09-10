package com.example;

import com.example.models.Role;
import com.example.models.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Init {

    private final UserService userService;
    private final RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createUsers() {
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        roleService.addRole(user);
        roleService.addRole(admin);
        Set<Role> roles = new HashSet<>();

        roles.add(user);
        User user1 = new User("qwa", "$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e");//$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e
        user1.setRoles(roles);
        user1.setEmail("qwa@qwa.qwa");
        user1.setAge(12);

        roles = new HashSet<>();
        roles.add(user);
        roles.add(admin);
        User user2 = new User("ewq", "$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e");
        user2.setRoles(roles);
        user2.setEmail("ewq@qwa.qwa");
        user2.setAge(32);

        userService.saveUser(user1);
        userService.saveUser(user2);


    }

}