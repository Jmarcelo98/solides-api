package com.desafio.solidesapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafio.solidesapi.handlers.BusinessException;
import com.desafio.solidesapi.mappers.AlbumMapper;
import com.desafio.solidesapi.model.dto.AlbumDTO;
import com.desafio.solidesapi.model.entities.Album;
import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.repositories.AlbumRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumService {

	private final AlbumRepository albumRepository;

	private final FotoService fotoService;

	public Page<AlbumDTO> buscarTodos(Pageable pageable) {
		return AlbumMapper.INSTANCE.pageEntityToPageDTO(albumRepository.findAll(pageable));
	}

	public Integer criar(AlbumDTO albumDTO, Usuario usuarioLogado) {
		var album = albumRepository
				.save(Album.builder().id(null).titulo(albumDTO.getTitulo()).usuario(usuarioLogado).build());
		fotoService.criar(albumDTO.getFotos(), album);

		return album.getId();	
	}

	public void deletar(Integer idAlbum, Usuario usuarioLogado) {

		if (verificarSeUsuarioLogadoPodeDeletarAlbum(idAlbum, usuarioLogado)) {
			throw new BusinessException("Você só pode excluir seus próprios albuns");
		}

		albumRepository.deleteById(idAlbum);

	}

//	private

	private Boolean verificarSeUsuarioLogadoPodeDeletarAlbum(Integer id, Usuario usuarioLogado) {
		return albumRepository.existsByIdAndUsuario(id, usuarioLogado);
	}

}
