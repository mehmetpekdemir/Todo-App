package com.mehmetpekdemir.todoapp.infra.adapters.user.rest.dto.response;

import com.mehmetpekdemir.todoapp.domain.user.model.Login;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponse {

    private String token;

    public static UserLoginResponse fromModel(Login login) {
        return UserLoginResponse.builder()
                .token(login.getToken())
                .build();
    }

}
