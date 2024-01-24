package com.desafio.solidesapi.controllers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.desafio.solidesapi.config.security.service.TokenService;
import com.desafio.solidesapi.model.record.UsuarioRecord;
import com.desafio.solidesapi.model.entities.Usuario;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class AutenticacaoController {

	private final AuthenticationManager authenticationManager;

	private final TokenService tokenService;

	@PostMapping
	public String logar(@RequestBody UsuarioRecord loginRecord) {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				loginRecord.login(), loginRecord.senha());

		Authentication auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		var usuario = (Usuario) auth.getPrincipal();

		return tokenService.gerarToken(usuario);

	}

	@GetMapping
	public String aa() {

		 return "a";

	}


}
