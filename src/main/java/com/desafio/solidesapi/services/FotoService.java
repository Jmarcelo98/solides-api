package com.desafio.solidesapi.services;

import com.desafio.solidesapi.model.dto.FotoDTO;
import com.desafio.solidesapi.model.dto.PostDTO;
import com.desafio.solidesapi.model.entities.Album;
import com.desafio.solidesapi.model.entities.Foto;
import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.repositories.FotoRepository;
import com.desafio.solidesapi.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FotoService {

	private final FotoRepository fotoRepository;

	public void criar(List<FotoDTO> fotoDTO, Album album) {
		fotoDTO.forEach(obj -> fotoRepository.save(Foto.builder().id(null).album(album).imagem(obj.getImagem()).build()) );

	}

}
