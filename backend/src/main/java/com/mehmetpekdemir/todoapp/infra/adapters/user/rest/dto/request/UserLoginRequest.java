package com.mehmetpekdemir.todoapp.infra.adapters.user.rest.dto.request;

import com.mehmetpekdemir.todoapp.domain.user.command.UserLogin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

    @NotNull
    @Size(min = 4, max = 32)
    private String username;

    @NotNull
    @Size(min = 4, max = 32)
    private String password;

    public UserLogin toModel() {
        return UserLogin.builder()
                .username(username)
                .password(password)
                .build();
    }

}
