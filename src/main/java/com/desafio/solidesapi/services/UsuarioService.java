package com.desafio.solidesapi.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.solidesapi.handlers.BusinessException;
import com.desafio.solidesapi.handlers.ResourceNotFoundException;
import com.desafio.solidesapi.mappers.UsuarioMapper;
import com.desafio.solidesapi.model.dto.UsuarioDTO;
import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.model.record.UsuarioRecord;
import com.desafio.solidesapi.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public Usuario buscarUsuarioLogado(String login) throws UsernameNotFoundException {
		return usuarioRepository.findByLoginIgnoreCase(login)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
	}

	public UsuarioDTO criar(UsuarioRecord usuarioRecord) {

		if (existsByLogin(usuarioRecord.login())) {
			throw new BusinessException("Login de usuário já existente");
		}
		final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();

		var usuario = Usuario.builder().id(null).login(usuarioRecord.login())
				.senha(bCrypt.encode(usuarioRecord.senha())).build();
		usuarioRepository.save(usuario);
		return UsuarioMapper.INSTANCE.entityToDTO(usuario);
	}

	// privados

	private Boolean existsByLogin(String login) {
		return usuarioRepository.existsByLoginIgnoreCase(login);
	}
}
