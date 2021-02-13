package com.mehmetpekdemir.todoapp.domain.user.facade;

import com.mehmetpekdemir.todoapp.domain.user.command.UserLogin;
import com.mehmetpekdemir.todoapp.domain.user.command.UserSignUp;
import com.mehmetpekdemir.todoapp.domain.user.model.Login;
import com.mehmetpekdemir.todoapp.domain.user.port.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    @Transactional
    public Login login(UserLogin userLogin) {
        return userRepository.login(userLogin);
    }

    @Transactional
    public Login signUp(UserSignUp userSignUp) {
         return userRepository.signUp(userSignUp);
    }

}
