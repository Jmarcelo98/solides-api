package com.desafio.solidesapi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.solidesapi.config.security.AppContextHolder;
import com.desafio.solidesapi.model.dto.PostDTO;
import com.desafio.solidesapi.model.record.PostFiltroRecord;
import com.desafio.solidesapi.services.PostService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

	private final PostService postService;

	private final AppContextHolder appContextHolder;

	@PostMapping
	public void criar(@RequestBody PostDTO postDTO) {
		postService.criar(postDTO, appContextHolder.getUsuario());
	}

	@PostMapping("/filtro")
	public Page<PostDTO> consultarPorFiltro(@RequestBody PostFiltroRecord postFiltroRecord, Pageable pageable) {
		return postService.consultarPorFiltro(postFiltroRecord, pageable);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer id) {
		postService.deletar(id, appContextHolder.getUsuario());
	}

}
