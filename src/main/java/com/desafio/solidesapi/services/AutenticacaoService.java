package com.desafio.solidesapi.services;

import com.desafio.solidesapi.handlers.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafio.solidesapi.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AutenticacaoService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByLoginIgnoreCase(username).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
	}

}
