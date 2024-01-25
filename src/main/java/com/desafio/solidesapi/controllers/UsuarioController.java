package com.desafio.solidesapi.controllers;

import com.desafio.solidesapi.model.dto.UsuarioDTO;
import com.desafio.solidesapi.model.record.UsuarioRecord;
import com.desafio.solidesapi.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
@CrossOrigin
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	public UsuarioDTO criar(@RequestBody UsuarioRecord usuarioRecord) {
		return usuarioService.criar(usuarioRecord);
	}

}
