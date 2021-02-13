package com.mehmetpekdemir.todoapp.infra.configuration.security;

import com.mehmetpekdemir.todoapp.domain.common.TodoBusinessException;
import com.mehmetpekdemir.todoapp.infra.adapters.user.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
class AuthService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userJpaRepository.findByUsername(username)
                .orElseThrow(() -> new TodoBusinessException("user.not.found"));
    }

}
