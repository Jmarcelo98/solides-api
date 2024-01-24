package com.desafio.solidesapi.repositories;

import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT p FROM Post p  "
            + "WHERE (:texto IS NULL OR UPPER(p.texto) = :texto ) "
            + "AND (:link IS NULL OR UPPER(p.link) = :link ) "
            + "AND (:id IS NULL OR p.id = :id ) ")
    List<Post> consultarPorFiltro(@Param(value = "texto") String texto, @Param(value = "link") String link, @Param(value = "id") Integer id);

    Boolean existsByIdAndUsuario(Integer id, Usuario usuario);

}
