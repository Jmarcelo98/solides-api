package com.desafio.solidesapi.services;

import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StartDbServiceDev {

	private UsuarioRepository usuarioRepository;

	public void instanciarDados() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		var usuario = Usuario.builder().id(null).login("joao").senha(encoder.encode("123")).build();
		var usuario1 = Usuario.builder().id(null).login("tauany").senha(encoder.encode("123")).build();

		usuarioRepository.saveAll(Arrays.asList(usuario, usuario1));

	}

}
