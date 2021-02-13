package com.mehmetpekdemir.todoapp.domain.todo.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
public class Todo {

    private Long id;

    private String text;

    private Boolean status;

}
