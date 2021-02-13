package com.mehmetpekdemir.todoapp.infra.adapters.todo.rest.dto.response;

import com.mehmetpekdemir.todoapp.domain.todo.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {

    private Long id;

    private String text;

    private Boolean status;

    public static TodoResponse fromModel(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .text(todo.getText())
                .status(todo.getStatus())
                .build();
    }

    public static List<TodoResponse> fromListOfModel(List<Todo> todos) {
        return todos.stream()
                .map(TodoResponse::fromModel)
                .collect(Collectors.toList());
    }

}
