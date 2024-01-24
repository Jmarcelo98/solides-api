package com.desafio.solidesapi.repositories;

import com.desafio.solidesapi.model.entities.Album;
import com.desafio.solidesapi.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Boolean existsByIdAndUsuario(Integer id, Usuario usuario);

}
