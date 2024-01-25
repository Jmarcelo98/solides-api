package com.desafio.solidesapi.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.desafio.solidesapi.handlers.BusinessException;
import com.desafio.solidesapi.mappers.PostMapper;
import com.desafio.solidesapi.model.entities.Comentario;
import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.model.record.ComentarioRecord;
import com.desafio.solidesapi.repositories.ComentarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComentarioService {

	private final ComentarioRepository comentarioRepository;

	private final PostService postService;

	public void criar(ComentarioRecord comentarioRecord, Usuario usuarioLogado) {

		var comentario = Comentario.builder().id(null).comentario(comentarioRecord.comentario())
				.post(PostMapper.INSTANCE.DTOToEntity(postService.consultarPorId(comentarioRecord.idPost())))
				.usuario(usuarioLogado).dataCriacao(LocalDate.now()).build();

		comentarioRepository.save(comentario);

	}

	public void deletar(Integer id, Usuario usuarioLogado) {
		if (!verificarSeUsuarioLogadoPodeDeletarComentario(id, usuarioLogado)) {
			throw new BusinessException("Você só pode excluir seus próprios comentários");
		}

		comentarioRepository.deleteById(id);
	}

//	privado

	private Boolean verificarSeUsuarioLogadoPodeDeletarComentario(Integer id, Usuario usuarioLogado) {
		return comentarioRepository.existsByIdAndUsuario(id, usuarioLogado);
	}

}
