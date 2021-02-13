package com.mehmetpekdemir.todoapp.infra.configuration.security;

import com.mehmetpekdemir.todoapp.domain.common.TodoBusinessException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@RequiredArgsConstructor
class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String token = jwtTokenProvider.resolveToken(request);
        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (TodoBusinessException todoBusinessException) {
            SecurityContextHolder.clearContext();
            response.sendError(422, todoBusinessException.getMessage());
            return;
        }

        filterChain.doFilter(request, response);
    }

}