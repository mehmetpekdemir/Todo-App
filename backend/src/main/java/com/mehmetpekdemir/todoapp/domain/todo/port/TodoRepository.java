package com.mehmetpekdemir.todoapp.domain.todo.port;

import com.mehmetpekdemir.todoapp.domain.todo.command.TodoCreate;
import com.mehmetpekdemir.todoapp.domain.todo.command.TodoUpdate;
import com.mehmetpekdemir.todoapp.domain.todo.model.Todo;

import java.util.List;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface TodoRepository {

    Todo getTodoById(Long id);

    List<Todo> getAllTodosByUsername(String username);

    Todo createTodo(TodoCreate todoCreate);

    Todo updateTodo(TodoUpdate todoUpdate);

    void deleteTodoById(Long id);

}
