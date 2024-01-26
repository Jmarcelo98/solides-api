package com.desafio.solidesapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.model.entities.Usuario;

public interface PostRepository extends JpaRepository<Post, Integer> {

	@Query(value = "SELECT p FROM Post p  " + "WHERE (:texto IS NULL OR UPPER(p.texto) LIKE CONCAT ('%',:texto,'%') ) "
			+ "AND (:link IS NULL OR UPPER(p.link) LIKE CONCAT ('%',:link,'%') ) "
			+ "AND (:idPost IS NULL OR p.id = :idPost ) " 
			+ "AND (:idUsuario IS NULL OR p.usuario = :idUsuario ) " )
	Page<Post> consultarPorFiltro(@Param(value = "texto") String texto, @Param(value = "link") String link,
			@Param(value = "idPost") Integer idPost, @Param(value = "idUsuario") Usuario idUsuario, Pageable pageable);

	Boolean existsByIdAndUsuario(Integer id, Usuario usuario);

}
