package com.desafio.solidesapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.model.entities.Usuario;

public interface PostRepository extends JpaRepository<Post, Integer> {

//	LIKE CONCAT('%',:username,'%')
    @Query(value = "SELECT p FROM Post p  "
//    		+ "WHERE (:texto IS NULL OR UPPER(p.texto) LIKE %:texto% "
            + "WHERE (:texto IS NULL OR UPPER(p.texto) = :texto ) "
            + "AND (:link IS NULL OR UPPER(p.link) = :link ) "
            + "AND (:id IS NULL OR p.id = :id ) ")
    Page<Post> consultarPorFiltro(@Param(value = "texto") String texto, @Param(value = "link") String link, @Param(value = "id") Integer id, Pageable pageable);

    Boolean existsByIdAndUsuario(Integer id, Usuario usuario);

}
