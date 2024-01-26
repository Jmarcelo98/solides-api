package com.desafio.solidesapi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.solidesapi.config.security.AppContextHolder;
import com.desafio.solidesapi.model.dto.AlbumDTO;
import com.desafio.solidesapi.model.record.AlbumFiltroRecord;
import com.desafio.solidesapi.services.AlbumService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/albuns")
@AllArgsConstructor
public class AlbumController {

	private final AlbumService albumService;

	private final AppContextHolder appContextHolder;

	@PostMapping("/todos")
	public Page<AlbumDTO> consultarTodos(@RequestBody AlbumFiltroRecord albumFiltroRecord, Pageable pageable) {
		return albumService.consultarPorFiltro(albumFiltroRecord, pageable, appContextHolder.getUsuario());
	}

	@PostMapping
	public Integer criar(@RequestBody AlbumDTO albumDTO) {
		return albumService.criar(albumDTO, appContextHolder.getUsuario());
	}

	@GetMapping("/{id}")
	public AlbumDTO consultarPorId(@PathVariable("id") Integer id) {
		return albumService.consultarPorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer id) {
		albumService.deletar(id, appContextHolder.getUsuario());
	}

}
