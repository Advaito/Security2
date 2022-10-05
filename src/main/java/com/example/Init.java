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
        roles.add(admin);
        User user1 = new User("qwa", "$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e");
        user1.setRoles(roles);
        user1.setEmail("qwa@qwa.qwa");
        user1.setName("User1");
        user1.setSurname("Resu1");
        user1.setAge(12);

        Set<Role> roles2 = new HashSet<>();

        roles2.add(user);
        User user2 = new User("dsa", "$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e");
        user2.setRoles(roles2);
        user2.setEmail("dsa@qwa.qwa");
        user2.setName("User2");
        user2.setSurname("Resu3");
        user2.setAge(44);

        userService.saveUser(user1);
        userService.saveUser(user2);


    }

}