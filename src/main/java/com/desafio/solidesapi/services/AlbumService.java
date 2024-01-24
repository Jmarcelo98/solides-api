package com.desafio.solidesapi.services;

import com.desafio.solidesapi.handlers.BusinessException;
import com.desafio.solidesapi.handlers.ResourceNotFoundException;
import com.desafio.solidesapi.mappers.AlbumMapper;
import com.desafio.solidesapi.model.dto.AlbumDTO;
import com.desafio.solidesapi.model.dto.PostDTO;
import com.desafio.solidesapi.model.entities.Album;
import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.repositories.AlbumRepository;
import com.desafio.solidesapi.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumService {

	private final AlbumRepository albumRepository;

	private final FotoService fotoService;

	public List<AlbumDTO> buscarTodos() {
		var todos = albumRepository.findAll();
		return AlbumMapper.INSTANCE.listaEntityToListaDTO(todos);
	}
	public void criar(AlbumDTO albumDTO, Usuario usuarioLogado) {
		var album = albumRepository.save( Album.builder().id(null).titulo(albumDTO.getTitulo()).usuario(usuarioLogado).build() );
		fotoService.criar(albumDTO.getFotos(), album);
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
