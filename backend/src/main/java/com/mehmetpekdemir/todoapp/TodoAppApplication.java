package com.mehmetpekdemir.todoapp;

import com.mehmetpekdemir.todoapp.infra.adapters.todo.jpa.adapter.TodoJpaAdapter;
import com.mehmetpekdemir.todoapp.infra.adapters.todo.rest.dto.request.TodoCreateRequest;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.adapter.UserJpaAdapter;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity.RoleEntity;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.repository.RoleJpaRepository;
import com.mehmetpekdemir.todoapp.infra.adapters.user.rest.dto.request.UserSignUpRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@EnableJpaAuditing
@SpringBootApplication
public class TodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialData(RoleJpaRepository roleJpaRepository, UserJpaAdapter userJpaAdapter, TodoJpaAdapter todoJpaAdapter) {
        return (args) -> {
            //Create Role = ADMIN
            RoleEntity roleAdmin = new RoleEntity();
            roleAdmin.setName("ADMIN");
            roleJpaRepository.save(roleAdmin);

            //Create Role = USER
            RoleEntity roleUser = new RoleEntity();
            roleUser.setName("USER");
            roleJpaRepository.save(roleUser);

            //Create User1
            UserSignUpRequest userSignUpRequest = new UserSignUpRequest("Mehmet1", "Mehmet1", "ADMIN");
            userJpaAdapter.signUp(userSignUpRequest.toModel());

            //Create User2
            UserSignUpRequest userSignUpRequest2 = new UserSignUpRequest("Mehmet2", "Mehmet2", "USER");
            userJpaAdapter.signUp(userSignUpRequest2.toModel());

            //Create Todo1
            TodoCreateRequest todoCreateRequest = new TodoCreateRequest("Test", true, "Mehmet1");
            todoJpaAdapter.createTodo(todoCreateRequest.toModel());

            //Create Todo2
            TodoCreateRequest todoCreateRequest2 = new TodoCreateRequest("Test2", false, "Mehmet1");
            todoJpaAdapter.createTodo(todoCreateRequest2.toModel());

            //Create Todo3
            TodoCreateRequest todoCreateRequest3 = new TodoCreateRequest("Test3", true, "Mehmet2");
            todoJpaAdapter.createTodo(todoCreateRequest3.toModel());

        };
    }


}
