package com.desafio.solidesapi.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.desafio.solidesapi.config.security.service.TokenService;
import com.desafio.solidesapi.repositories.UsuarioRepository;

@Component
@AllArgsConstructor
public class FiltroToken extends OncePerRequestFilter {

	private final TokenService tokenService;

	private final UsuarioRepository usuarioRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token;

		var authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null) {
			token = authorizationHeader.replace("Bearer ", "");
			var subject = this.tokenService.getSubject(token);

			var usuario = this.usuarioRepository.findByLoginIgnoreCase(subject);

			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, null);

			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		filterChain.doFilter(request, response);

	}
}
