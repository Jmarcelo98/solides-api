package com.desafio.solidesapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.solidesapi.config.security.AppContextHolder;
import com.desafio.solidesapi.model.dto.AlbumDTO;
import com.desafio.solidesapi.services.AlbumService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/album")
@AllArgsConstructor
@CrossOrigin
public class AlbumController {

	private final AlbumService albumService;

	private final AppContextHolder appContextHolder;

	@GetMapping("/todos")
	public List<AlbumDTO> consultarTodos() {
		return albumService.buscarTodos();
	}

	@PostMapping
	public void criar(@RequestBody AlbumDTO albumDTO) {
		albumService.criar(albumDTO, appContextHolder.getUsuario());
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer id) {
		albumService.deletar(id, appContextHolder.getUsuario());
	}

}