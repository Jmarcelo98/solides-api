package com.desafio.solidesapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.solidesapi.model.entities.Album;
import com.desafio.solidesapi.model.entities.Usuario;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

	@Query(value = "SELECT a FROM Album a "
			+ "WHERE (:titulo IS NULL OR UPPER(a.titulo) LIKE CONCAT ('%',:titulo,'%') ) "
			+ "AND (:idUsuario IS NULL OR a.usuario = :idUsuario ) ")
	Page<Album> consultarPorFiltro(@Param(value = "titulo") String titulo,
			@Param(value = "idUsuario") Usuario idUsuario, Pageable pageable);

	Boolean existsByIdAndUsuario(Integer id, Usuario usuario);

}
