package com.mehmetpekdemir.todoapp.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public abstract class AbstractIT {

    @Autowired
    protected MockMvc mockMvc;

}
