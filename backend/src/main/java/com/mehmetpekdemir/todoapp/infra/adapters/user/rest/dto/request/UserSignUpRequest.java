package com.mehmetpekdemir.todoapp.infra.adapters.user.rest.dto.request;

import com.mehmetpekdemir.todoapp.domain.user.command.UserSignUp;
import com.mehmetpekdemir.todoapp.infra.common.validator.UniqueUsername;
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
public class UserSignUpRequest {

    @NotNull
    @Size(min = 4, max = 32)
    @UniqueUsername
    private String username;

    @NotNull
    @Size(min = 4, max = 32)
    private String password;

    @NotNull
    @Size(min = 2, max = 32)
    private String roleName;

    public UserSignUp toModel() {
        return UserSignUp.builder()
                .username(username)
                .password(password)
                .roleName(roleName)
                .build();
    }

}
