package com.mehmetpekdemir.todoapp.domain.todo.facade;

import com.mehmetpekdemir.todoapp.domain.todo.command.TodoCreate;
import com.mehmetpekdemir.todoapp.domain.todo.command.TodoUpdate;
import com.mehmetpekdemir.todoapp.domain.todo.model.Todo;
import com.mehmetpekdemir.todoapp.domain.todo.port.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class TodoFacade {

    private final TodoRepository todoRepository;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Todo getTodoById(Long id) {
        return todoRepository.getTodoById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Todo> getAllTodosByUsername(String username) {
        return todoRepository.getAllTodosByUsername(username);
    }

    @Transactional
    public Todo createTodo(TodoCreate todoCreate) {
        return todoRepository.createTodo(todoCreate);
    }

    @Transactional
    public Todo updateTodo(TodoUpdate todoUpdate) {
        return todoRepository.updateTodo(todoUpdate);
    }

    @Transactional
    public void deleteTodoById(Long id) {
        todoRepository.deleteTodoById(id);
    }

}
