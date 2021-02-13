package com.mehmetpekdemir.todoapp.domain.user.port;

import com.mehmetpekdemir.todoapp.domain.user.command.UserLogin;
import com.mehmetpekdemir.todoapp.domain.user.command.UserSignUp;
import com.mehmetpekdemir.todoapp.domain.user.model.Login;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public interface UserRepository {

    Login login(UserLogin userLogin);

    Login signUp(UserSignUp userSignUp);

}
