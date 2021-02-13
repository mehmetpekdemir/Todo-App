package com.mehmetpekdemir.todoapp.domain.todo.command;

import lombok.Builder;
import lombok.Data;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
public class TodoUpdate {

    private Long id;

    private String text;

    private Boolean status;

    private String username;

}
