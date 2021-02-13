package com.mehmetpekdemir.todoapp.infra.adapters.user.rest.controller;

import com.mehmetpekdemir.todoapp.domain.user.facade.UserFacade;
import com.mehmetpekdemir.todoapp.infra.adapters.user.rest.dto.request.UserLoginRequest;
import com.mehmetpekdemir.todoapp.infra.adapters.user.rest.dto.request.UserSignUpRequest;
import com.mehmetpekdemir.todoapp.infra.adapters.user.rest.dto.response.UserLoginResponse;
import com.mehmetpekdemir.todoapp.infra.common.rest.BaseController;
import com.mehmetpekdemir.todoapp.infra.common.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserFacade userFacade;

    @PostMapping("login")
    public Response<?> login(@Valid @RequestBody UserLoginRequest loginRequest) {
        final var response = userFacade.login(loginRequest.toModel());
        return respond(UserLoginResponse.fromModel(response));
    }

    @PostMapping("sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<?> signUp(@Valid @RequestBody UserSignUpRequest userSignUpRequest) {
        final var response = userFacade.signUp(userSignUpRequest.toModel());
        return respond(UserLoginResponse.fromModel(response));
    }

}
