package com.example.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String name;

    @Override
    public String getAuthority() {
        return getName();
    }

    public Role(String name) {
        this.name = name;
    }

}
