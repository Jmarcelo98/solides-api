package com.desafio.solidesapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.solidesapi.model.dto.UsuarioDTO;
import com.desafio.solidesapi.model.record.UsuarioRecord;
import com.desafio.solidesapi.services.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	public UsuarioDTO criar(@RequestBody UsuarioRecord usuarioRecord) {
		return usuarioService.criar(usuarioRecord);
	}

}
