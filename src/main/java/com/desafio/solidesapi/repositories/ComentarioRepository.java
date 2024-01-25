package com.desafio.solidesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.solidesapi.model.entities.Comentario;
import com.desafio.solidesapi.model.entities.Usuario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	Boolean existsByIdAndUsuario(Integer id, Usuario usuario);
	
}
