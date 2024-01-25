package com.desafio.solidesapi.config.security;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.services.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AppContextHolder {

	private final UsuarioService usuarioService;

	public Usuario getUsuario() {

		Optional<Usuario> login = (Optional<Usuario>) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		return usuarioService.buscarUsuarioLogado((String) login.get().getLogin());

	}
}