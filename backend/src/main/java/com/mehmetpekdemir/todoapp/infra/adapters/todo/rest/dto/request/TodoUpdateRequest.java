package com.mehmetpekdemir.todoapp.infra.adapters.todo.rest.dto.request;

import com.mehmetpekdemir.todoapp.domain.todo.command.TodoUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoUpdateRequest {

    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private Boolean status;

    @NotNull
    private String username;

    public TodoUpdate toModel() {
        return TodoUpdate.builder()
                .id(id)
                .text(text)
                .status(status)
                .username(username)
                .build();
    }

}
