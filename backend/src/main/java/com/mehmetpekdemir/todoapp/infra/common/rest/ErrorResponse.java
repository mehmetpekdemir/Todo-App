package com.mehmetpekdemir.todoapp.infra.common.rest;

import lombok.Builder;
import lombok.Data;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
class ErrorResponse {

    private String errorCode;

    private String errorDescription;

}