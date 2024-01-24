package com.desafio.solidesapi.services;

import com.desafio.solidesapi.handlers.BusinessException;
import com.desafio.solidesapi.mappers.PostMapper;
import com.desafio.solidesapi.model.dto.PostDTO;
import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.model.record.input.PostInputRecord;
import com.desafio.solidesapi.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService  {

	private final PostRepository postRepository;

	public void criar(PostDTO postDTO, Usuario usuarioLogado) {
		postRepository.save(Post.builder().id(null).texto(postDTO.getTexto()).imagem(postDTO.getImagem()).usuario(usuarioLogado).build());
	}

	public List<PostDTO> consultarPorFiltro(PostInputRecord postInputRecord) {
		var todos = postRepository.consultarPorFiltro(postInputRecord.texto(), postInputRecord.link(), postInputRecord.id());
		return PostMapper.INSTANCE.listaEntityToListaDTO(todos);
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
