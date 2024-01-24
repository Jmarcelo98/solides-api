package com.desafio.solidesapi.controllers;

import com.desafio.solidesapi.config.security.AppContextHolder;
import com.desafio.solidesapi.config.security.service.TokenService;
import com.desafio.solidesapi.model.dto.PostDTO;
import com.desafio.solidesapi.model.record.input.PostInputRecord;
import com.desafio.solidesapi.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

	private final PostService postService;

	private final AppContextHolder appContextHolder;

	@PostMapping
	public void criar(@RequestBody PostDTO postDTO) {
		postService.criar(postDTO, appContextHolder.getUsuario());
	}

	@GetMapping
	public List<PostDTO> consultarPorFiltro(PostInputRecord postInputRecord) {
		return postService.consultarPorFiltro(postInputRecord);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer id ){
		postService.deletar(id, appContextHolder.getUsuario());
	}

}
