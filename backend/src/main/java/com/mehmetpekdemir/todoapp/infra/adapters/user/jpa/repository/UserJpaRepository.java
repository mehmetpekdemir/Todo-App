package com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.repository;

import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    boolean existsUserByUsername(String username);

}
