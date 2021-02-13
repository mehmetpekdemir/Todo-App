package com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity;

import com.mehmetpekdemir.todoapp.infra.adapters.todo.jpa.entity.TodoEntity;
import com.mehmetpekdemir.todoapp.infra.common.entity.AbstractBaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends AbstractBaseEntity implements UserDetails {

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private RoleEntity role;

    @OneToMany(mappedBy = "user")
    private List<TodoEntity> todos = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(getRole().getName()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
