package com.desafio.solidesapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.solidesapi.model.dto.FotoDTO;
import com.desafio.solidesapi.model.entities.Album;
import com.desafio.solidesapi.model.entities.Foto;
import com.desafio.solidesapi.repositories.FotoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FotoService {

	private final FotoRepository fotoRepository;

	public void criar(List<FotoDTO> fotoDTO, Album album) {
		fotoDTO.forEach(
				obj -> fotoRepository.save(Foto.builder().id(null).album(album).imagem(obj.getImagem()).build()));

	}

}
