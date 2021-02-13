package com.mehmetpekdemir.todoapp.domain.user.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
public class Login {

    private String token;

}
