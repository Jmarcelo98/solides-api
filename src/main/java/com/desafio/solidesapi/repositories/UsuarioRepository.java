package com.desafio.solidesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.solidesapi.model.entities.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByLoginIgnoreCase(String login);

	Boolean existsByLoginIgnoreCase(String login);

}
