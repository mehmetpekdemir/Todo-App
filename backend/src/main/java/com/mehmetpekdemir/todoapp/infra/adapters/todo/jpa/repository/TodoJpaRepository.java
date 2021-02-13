package com.mehmetpekdemir.todoapp.infra.adapters.todo.jpa.repository;

import com.mehmetpekdemir.todoapp.infra.adapters.todo.jpa.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findAllByUserId(Long id);

    Optional<TodoEntity> findByIdAndUserId(Long id, Long userId);

}
