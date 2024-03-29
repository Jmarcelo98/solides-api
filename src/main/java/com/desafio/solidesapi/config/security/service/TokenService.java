package com.desafio.solidesapi.config.security.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.desafio.solidesapi.model.entities.Usuario;

@Service
public class TokenService {

	public String gerarToken(Usuario usuario) {

		return JWT.create().withSubject(usuario.getLogin()).withClaim("id", usuario.getId())
				.withExpiresAt(LocalDateTime.now().plusHours(730).toInstant(ZoneOffset.of("-03:00")))
				.sign(Algorithm.HMAC256("secreta"));
	}

	public String getSubject(String token) {
		return JWT.require(Algorithm.HMAC256("secreta")).build().verify(token).getSubject();

	}
}