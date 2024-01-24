package com.desafio.solidesapi.controllers;

import com.desafio.solidesapi.config.security.AppContextHolder;
import com.desafio.solidesapi.model.dto.AlbumDTO;
import com.desafio.solidesapi.model.dto.PostDTO;
import com.desafio.solidesapi.services.AlbumService;
import com.desafio.solidesapi.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
		albumService.criar(albumDTO, appContextHolder.getUsuario() );
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer id ){
		albumService.deletar(id, appContextHolder.getUsuario());
	}

}
