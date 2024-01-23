package com.desafio.solidesapi.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.solidesapi.config.security.service.TokenService;
import com.desafio.solidesapi.model.dto.LoginDTO;
import com.desafio.solidesapi.model.entities.Usuario;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticacaoController {

	private AuthenticationManager authenticationManager;

	private TokenService tokenService;

	@PostMapping
	public String login(@RequestBody LoginDTO loginDTO) {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				loginDTO.login(), loginDTO.senha());

		Authentication auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		var usuario = (Usuario) auth.getPrincipal();

		return tokenService.gerarToken(usuario);

	}

}
