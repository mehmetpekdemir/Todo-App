package com.mehmetpekdemir.todoapp.controller;

import com.mehmetpekdemir.todoapp.common.AbstractIT;
import com.mehmetpekdemir.todoapp.common.IT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@IT
@DisplayName("TodoIntegrationTests")
class TodoControllerIntegrationTests extends AbstractIT {

    @Test
    void test_get_todo_by_id() throws Exception {
        final String content = "" +
                "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"text\": \"Test\",\n" +
                "        \"status\": true\n" +
                "    },\n" +
                "    \"errors\": null,\n" +
                "    \"time\":" + LocalDate.now().toString() +
                "}";

        mockMvc.perform(
                get("/api/v1/todo/1")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(content)
        ).andDo(print());
    }

    @Test
    void test_get_all_todos_by_username() throws Exception {
        final String content = "" +
                "{\n" +
                "    \"data\": {\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"id\": 1,\n" +
                "                \"text\": \"Test\",\n" +
                "                \"status\": true\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 2,\n" +
                "                \"text\": \"Test2\",\n" +
                "                \"status\": false\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"errors\": null,\n" +
                "    \"time\":" + LocalDate.now().toString() +
                "}";

        mockMvc.perform(
                get("/api/v1/todo/username/Mehmet1")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(content)
        ).andDo(print());
    }

    @Test
    void test_create_todo() throws Exception {
        final String bodyContent = "" +
                "{\n" +
                "    \"text\": \"Test1\",\n" +
                "    \"status\": 1,\n" +
                "    \"username\": \"Mehmet1\"\n" +
                "}";

        final String responseContent = "" +
                "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 4,\n" +
                "        \"text\": \"Test1\",\n" +
                "        \"status\": true\n" +
                "    },\n" +
                "    \"errors\": null,\n" +
                "    \"time\":" + LocalDate.now().toString() +
                "}";

        mockMvc.perform(
                post("/api/v1/todo")
                        .content(bodyContent)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isCreated()
        ).andExpect(
                content().json(responseContent)
        ).andDo(print());
    }

    @Test
    void test_update_todo() throws Exception {
        final String bodyContent = "" +
                "{\n" +
                "    \"id\": 1,\n" +
                "    \"text\": \"Test test\",\n" +
                "    \"status\": 0,\n" +
                "    \"username\": \"Mehmet1\"\n" +
                "}";

        final String responseContent = "" +
                "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"text\": \"Test test\",\n" +
                "        \"status\": false\n" +
                "    },\n" +
                "    \"errors\": null,\n" +
                "    \"time\":" + LocalDate.now().toString() +
                "}";

        mockMvc.perform(
                put("/api/v1/todo")
                        .content(bodyContent)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(responseContent)
        ).andDo(print());
    }

    @Test
    void test_delete_todo_by_id() throws Exception {
        final String content = "" +
                "{\n" +
                "    \"data\": \"Successfully Deleted.\",\n" +
                "    \"errors\": null,\n" +
                "    \"time\":" + LocalDate.now().toString() +
                "}";

        mockMvc.perform(
                delete("/api/v1/todo/1")
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().json(content)
        ).andDo(print());
    }

}
