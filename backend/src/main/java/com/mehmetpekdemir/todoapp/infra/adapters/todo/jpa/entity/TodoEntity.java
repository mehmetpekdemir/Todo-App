package com.mehmetpekdemir.todoapp.infra.adapters.todo.jpa.entity;

import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity.UserEntity;
import com.mehmetpekdemir.todoapp.infra.common.entity.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = "todos")
public class TodoEntity extends AbstractBaseEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
