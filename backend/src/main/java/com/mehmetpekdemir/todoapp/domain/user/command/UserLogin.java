package com.mehmetpekdemir.todoapp.domain.user.command;

import lombok.Builder;
import lombok.Data;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
public class UserLogin {

    private String username;

    private String password;

}
