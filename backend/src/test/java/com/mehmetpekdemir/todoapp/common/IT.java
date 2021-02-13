package com.mehmetpekdemir.todoapp.common;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Tag("integrationTest")
@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
public @interface IT {
}
