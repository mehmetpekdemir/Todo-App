package com.mehmetpekdemir.todoapp.infra.common.constant;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public final class GenericMessages {

    private static final String UTILITY_CLASS = "Utility Class";

    private GenericMessages() {
        throw new IllegalArgumentException(UTILITY_CLASS);
    }

    public static final String SUCCESSFULLY_DELETED = "Successfully Deleted.";

}