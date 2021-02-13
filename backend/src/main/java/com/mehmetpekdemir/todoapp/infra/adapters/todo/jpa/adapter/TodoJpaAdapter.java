package com.mehmetpekdemir.todoapp.infra.adapters.todo.jpa.adapter;

import com.mehmetpekdemir.todoapp.domain.common.TodoBusinessException;
import com.mehmetpekdemir.todoapp.domain.todo.command.TodoCreate;
import com.mehmetpekdemir.todoapp.domain.todo.command.TodoUpdate;
import com.mehmetpekdemir.todoapp.domain.todo.model.Todo;
import com.mehmetpekdemir.todoapp.domain.todo.port.TodoRepository;
import com.mehmetpekdemir.todoapp.infra.adapters.todo.jpa.entity.TodoEntity;
import com.mehmetpekdemir.todoapp.infra.adapters.todo.jpa.repository.TodoJpaRepository;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity.UserEntity;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class TodoJpaAdapter implements TodoRepository {

    private final TodoJpaRepository todoJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Todo getTodoById(Long id) {
        return toModel(getById(id));
    }

    @Override
    public List<Todo> getAllTodosByUsername(String username) {
        final var userEntity = getUserByUsername(username);
        return todoJpaRepository.findAllByUserId(userEntity.getId())
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Todo createTodo(TodoCreate todoCreate) {
        final var userEntity = getUserByUsername(todoCreate.getUsername());
        final var todoEntity = new TodoEntity();
        todoEntity.setText(todoCreate.getText());
        todoEntity.setStatus(todoCreate.getStatus());
        todoEntity.setUser(userEntity);
        return toModel(todoJpaRepository.save(todoEntity));
    }

    @Override
    public Todo updateTodo(TodoUpdate todoUpdate) {
        final var todoEntity = getById(todoUpdate.getId());
        final var userEntity = getUserByUsername(todoUpdate.getUsername());
        final var todo = getTodoByUserIdAndTodoId(todoEntity.getId(), userEntity.getId());

        todo.setText(todoUpdate.getText());
        todo.setStatus(todoUpdate.getStatus());
        return toModel(todoJpaRepository.save(todo));
    }

    @Override
    public void deleteTodoById(Long id) {
        final var todoEntity = getById(id);
        todoJpaRepository.deleteById(todoEntity.getId());
    }

    private TodoEntity getById(Long id) {
        return todoJpaRepository.findById(id)
                .orElseThrow(() -> new TodoBusinessException("todo.not.found"));
    }

    private UserEntity getUserByUsername(String username) {
        return userJpaRepository.findByUsername(username)
                .orElseThrow(() -> new TodoBusinessException("user.not.found"));
    }

    private TodoEntity getTodoByUserIdAndTodoId(Long todoId, Long userId) {
        return todoJpaRepository.findByIdAndUserId(todoId, userId)
                .orElseThrow(() -> new TodoBusinessException("user.not.found"));
    }

    private Todo toModel(TodoEntity todoEntity) {
        return Todo.builder()
                .id(todoEntity.getId())
                .text(todoEntity.getText())
                .status(todoEntity.getStatus())
                .build();
    }

}
