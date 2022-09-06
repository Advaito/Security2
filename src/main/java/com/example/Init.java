package com.example;

import com.example.models.Role;
import com.example.models.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Init {

    private final UserService userService;
    private final RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsers() {
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        roleService.save(user);
        roleService.save(admin);

        User user1 = new User("qwa", "$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e");//$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e
        User user2 = new User("ewq", "$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e");
        User user3 = new User("qaz", "$2a$12$54rDWKSismZ9uGff8bWwvetMn/YqhjzHl0P3D7JxY8GSyXeI2zM9e");

        user1.addRole(roleService.findByName("ROLE_ADMIN"));
        user1.addRole(roleService.findByName("ROLE_USER"));
        user2.addRole(roleService.findByName("ROLE_ADMIN"));
        user3.addRole(roleService.findByName("ROLE_USER"));

        user1.setEmail("qwa@qwa.qwa");
        user1.setAge(12);

        user2.setEmail("ewq@ewq.ewq");
        user2.setAge(34);

        user3.setEmail("qaz@qaz.ru");
        user3.setAge(20);

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);

    }

}