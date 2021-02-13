package com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.repository;

import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface RoleJpaRepository extends JpaRepository<RoleEntity, Integer> {

    Optional<RoleEntity> findByName(String roleName);

}
