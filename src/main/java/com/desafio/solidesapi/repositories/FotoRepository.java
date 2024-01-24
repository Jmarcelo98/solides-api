package com.desafio.solidesapi.repositories;

import com.desafio.solidesapi.model.entities.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoRepository extends JpaRepository<Foto, Integer> {

}
