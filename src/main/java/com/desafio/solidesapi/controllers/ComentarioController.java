package com.desafio.solidesapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.solidesapi.config.security.AppContextHolder;
import com.desafio.solidesapi.model.record.ComentarioRecord;
import com.desafio.solidesapi.services.ComentarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/comentarios")
@AllArgsConstructor
public class ComentarioController {

	private final ComentarioService comentarioService;

	private final AppContextHolder appContextHolder;

	@PostMapping
	public void criar(@RequestBody ComentarioRecord comentarioRecord) {
		comentarioService.criar(comentarioRecord, appContextHolder.getUsuario());
	}

}
