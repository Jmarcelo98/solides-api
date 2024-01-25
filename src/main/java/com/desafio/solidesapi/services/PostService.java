package com.desafio.solidesapi.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desafio.solidesapi.handlers.BusinessException;
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

	public void criar(PostDTO postDTO, Usuario usuarioLogado) {
		postRepository.save(Post.builder().id(null).texto(postDTO.getTexto()).imagem(postDTO.getImagem())
				.usuario(usuarioLogado).build());
	}

	public Page<PostDTO> consultarPorFiltro(PostFiltroRecord postFiltroRecord, Pageable pageable) {

		var lista = postRepository.consultarPorFiltro(
				postFiltroRecord.texto() != null ? postFiltroRecord.texto() : null,
				postFiltroRecord.link() != null ? postFiltroRecord.link() : null,
				postFiltroRecord.id() != null ? postFiltroRecord.id() : null, pageable);

		return PostMapper.INSTANCE.pageEntityToPageDTO(lista);
	}

	public List<PostDTO> all() {
		return PostMapper.INSTANCE.listaEntityToListaDTO(postRepository.findAll());
	}

	public void deletar(Integer idPost, Usuario usuarioLogado) {

		if (verificarSeUsuarioLogadoPodeDeletarPost(idPost, usuarioLogado)) {
			throw new BusinessException("Você só pode excluir seus próprios posts");
		}

		postRepository.deleteById(idPost);

	}

//	private

	private Boolean verificarSeUsuarioLogadoPodeDeletarPost(Integer id, Usuario usuarioLogado) {
		return postRepository.existsByIdAndUsuario(id, usuarioLogado);
	}

}
