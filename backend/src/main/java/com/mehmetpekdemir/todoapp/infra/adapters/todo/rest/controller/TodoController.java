package com.mehmetpekdemir.todoapp.infra.adapters.todo.rest.controller;

import com.mehmetpekdemir.todoapp.domain.todo.facade.TodoFacade;
import com.mehmetpekdemir.todoapp.infra.adapters.todo.rest.dto.request.TodoCreateRequest;
import com.mehmetpekdemir.todoapp.infra.adapters.todo.rest.dto.request.TodoUpdateRequest;
import com.mehmetpekdemir.todoapp.infra.adapters.todo.rest.dto.response.TodoResponse;
import com.mehmetpekdemir.todoapp.infra.common.constant.GenericMessages;
import com.mehmetpekdemir.todoapp.infra.common.rest.BaseController;
import com.mehmetpekdemir.todoapp.infra.common.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("api/v1/todo")
@RequiredArgsConstructor
public class TodoController extends BaseController {

    private final TodoFacade todoFacade;

    @GetMapping("{id}")
    public Response<?> getTodoById(@PathVariable(value = "id") Long id) {
        final var todo = todoFacade.getTodoById(id);
        return respond(TodoResponse.fromModel(todo));
    }

    @GetMapping("username/{username}")
    public Response<?> getAllTodosByUsername(@PathVariable(value = "username") String username) {
        final var todos = todoFacade.getAllTodosByUsername(username);
        return respond(TodoResponse.fromListOfModel(todos));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<?> createTodo(@Valid @RequestBody TodoCreateRequest todoCreateRequest) {
        final var todo = todoFacade.createTodo(todoCreateRequest.toModel());
        return respond(TodoResponse.fromModel(todo));
    }

    @PutMapping
    public Response<?> updateTodo(@Valid @RequestBody TodoUpdateRequest todoUpdateRequest) {
        final var todo = todoFacade.updateTodo(todoUpdateRequest.toModel());
        return respond(TodoResponse.fromModel(todo));
    }

    @DeleteMapping("{id}")
    public Response<?> deleteTodoById(@PathVariable(value = "id") Long id) {
        todoFacade.deleteTodoById(id);
        return respond(GenericMessages.SUCCESSFULLY_DELETED);
    }

}
