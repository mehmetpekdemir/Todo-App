package com.mehmetpekdemir.todoapp.infra.common.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {UniqueUsernameValidator.class})
public @interface UniqueUsername {

    String message() default "Username must be unique.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
