package com.mehmetpekdemir.todoapp.infra.adapters.todo.rest.dto.request;

import com.mehmetpekdemir.todoapp.domain.todo.command.TodoCreate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoCreateRequest {

    @NotNull
    private String text;

    @NotNull
    private Boolean status;

    @NotNull
    private String username;

    public TodoCreate toModel() {
        return TodoCreate.builder()
                .text(text)
                .status(status)
                .username(username)
                .build();
    }

}
