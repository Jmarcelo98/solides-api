package com.desafio.solidesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.solidesapi.model.entities.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
