package com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.adapter;

import com.mehmetpekdemir.todoapp.domain.common.TodoBusinessException;
import com.mehmetpekdemir.todoapp.domain.user.command.UserLogin;
import com.mehmetpekdemir.todoapp.domain.user.command.UserSignUp;
import com.mehmetpekdemir.todoapp.domain.user.model.Login;
import com.mehmetpekdemir.todoapp.domain.user.port.UserRepository;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity.RoleEntity;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.entity.UserEntity;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.repository.RoleJpaRepository;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.repository.UserJpaRepository;
import com.mehmetpekdemir.todoapp.infra.configuration.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserJpaAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final RoleJpaRepository roleJpaRepository;

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Login login(UserLogin userLogin) {
        final String username = userLogin.getUsername();
        final String password = userLogin.getPassword();

        try {
            final var userEntity = findByUsername(username);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return toModel(jwtTokenProvider.createToken(username, userEntity.getRole()));
        } catch (AuthenticationException authenticationException) {
            throw new TodoBusinessException("invalid.username.or.password.supplied");
        }
    }

    @Override
    public Login signUp(UserSignUp userSignUp) {
        final var roleEntity = findRoleByRoleName(userSignUp.getRoleName());
        final UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userSignUp.getUsername());
        userEntity.setPassword(encodePassword(userSignUp.getPassword()));
        userEntity.setRole(roleEntity);
        userJpaRepository.save(userEntity);
        return toModel(jwtTokenProvider.createToken(userSignUp.getUsername(), roleEntity));
    }

    private UserEntity findByUsername(String username) {
        return userJpaRepository.findByUsername(username)
                .orElseThrow(() -> new TodoBusinessException("user.not.found"));
    }

    private RoleEntity findRoleByRoleName(String roleName) {
        return roleJpaRepository.findByName(roleName)
                .orElseThrow(() -> new TodoBusinessException("role.not.found"));
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private Login toModel(String token) {
        return Login.builder()
                .token(token)
                .build();
    }

}
