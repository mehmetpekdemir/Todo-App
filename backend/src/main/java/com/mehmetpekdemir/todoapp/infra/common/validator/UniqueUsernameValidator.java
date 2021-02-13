package com.mehmetpekdemir.todoapp.infra.common.validator;

import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return !userJpaRepository.existsUserByUsername(username);
    }

}
