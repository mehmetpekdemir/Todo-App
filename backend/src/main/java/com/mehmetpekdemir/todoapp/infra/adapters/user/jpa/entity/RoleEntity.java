package com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserEntity> users = new ArrayList<>();

}
