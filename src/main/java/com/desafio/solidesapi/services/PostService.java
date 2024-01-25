package com.desafio.solidesapi.services;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafio.solidesapi.handlers.BusinessException;
import com.desafio.solidesapi.handlers.ResourceNotFoundException;
import com.desafio.solidesapi.mappers.PostMapper;
import com.desafio.solidesapi.model.dto.PostDTO;
import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.model.record.PostFiltroRecord;
import com.desafio.solidesapi.repositories.PostRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	public Integer criar(PostDTO postDTO, Usuario usuarioLogado) {
		return postRepository.save(Post.builder().id(null).texto(postDTO.getTexto()).imagem(postDTO.getImagem())
				.dataCriacao(LocalDate.now()).usuario(usuarioLogado).build()).getId();
	}

	public PostDTO consultarPorId(Integer id) {
		return PostMapper.INSTANCE.entityToDTO(postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Post não encontrado pelo ID: " + id)));
	}

	public Page<PostDTO> consultarPorFiltro(PostFiltroRecord postFiltroRecord, Pageable pageable) {

		var lista = postRepository.consultarPorFiltro(
				postFiltroRecord.texto() != null ? postFiltroRecord.texto().toUpperCase() : null,
				postFiltroRecord.link() != null ? postFiltroRecord.link().toUpperCase() : null,
				postFiltroRecord.id() != null ? postFiltroRecord.id() : null, pageable);

		return PostMapper.INSTANCE.pageEntityToPageDTO(lista);
	}

	public void deletar(Integer idPost, Usuario usuarioLogado) {

		if (!verificarSeUsuarioLogadoPodeDeletarPost(idPost, usuarioLogado)) {
			throw new BusinessException("Você só pode excluir seus próprios posts");
		}

		postRepository.deleteById(idPost);

	}

//	private

	private Boolean verificarSeUsuarioLogadoPodeDeletarPost(Integer id, Usuario usuarioLogado) {
		return postRepository.existsByIdAndUsuario(id, usuarioLogado);
	}

}
