package com.mehmetpekdemir.todoapp.controller;

import com.mehmetpekdemir.todoapp.common.AbstractIT;
import com.mehmetpekdemir.todoapp.common.IT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@IT
@DisplayName("UserIntegrationTests")
class UserControllerIntegrationTests extends AbstractIT {

    @Test
    void test_successful_login() throws Exception {
        final String bodyContent =
                "{\n" +
                        "    \"username\": \"Mehmet1\",\n" +
                        "    \"password\": \"Mehmet1\"\n" +
                        "}";

        mockMvc.perform(
                post("/api/v1/user/login")
                        .content(bodyContent)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andDo(print());
    }

    @Test
    void test_unsuccessful_login_throw_user_not_found() throws Exception {
        final String bodyContent =
                "{\n" +
                        "    \"username\": \"Wrong\",\n" +
                        "    \"password\": \"Wrong\"\n" +
                        "}";

        final String responseContent = "" +
                "{\n" +
                "    \"data\": null,\n" +
                "    \"errors\": {\n" +
                "        \"errorCode\": \"400\",\n" +
                "        \"errorDescription\": \"User not found !\"\n" +
                "    },\n" +
                "    \"time\": " + LocalDate.now().toString() + "\n" +
                "}";

        mockMvc.perform(
                post("/api/v1/user/login")
                        .content(bodyContent)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isBadRequest()
        ).andExpect(
                content().json(responseContent)
        ).andDo(print());
    }

    @Test
    void test_successful_sign_up() throws Exception {
        final String bodyContent =
                "{\n" +
                        "    \"username\": \"Test\",\n" +
                        "    \"password\": \"Test\",\n" +
                        "    \"roleName\":\"USER\"\n" +
                        "}";

        mockMvc.perform(
                post("/api/v1/user/sign-up")
                        .content(bodyContent)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isCreated()
        ).andDo(print());
    }

    @Test
    void test_unsuccessful_sign_up_throw_username_must_be_unique() throws Exception {
        final String bodyContent = "" +
                "{\n" +
                "    \"username\": \"Mehmet1\",\n" +
                "    \"password\": \"Mehmet1\",\n" +
                "    \"roleName\": \"USER\"\n" +
                "}";

        final String responseContent = "" +
                "{\n" +
                "    \"data\": null,\n" +
                "    \"errors\": {\n" +
                "        \"errorCode\": \"400\",\n" +
                "        \"errorDescription\": \"Username must be unique.\"\n" +
                "    },\n" +
                "    \"time\": " + LocalDate.now().toString() + "\n" +
                "}";

        mockMvc.perform(
                post("/api/v1/user/sign-up")
                        .content(bodyContent)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                content().json(responseContent)
        ).andDo(print());
    }


}
