package com.desafio.solidesapi.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String texto;

	private String link;

	private LocalDate dataCriacao;

	@Lob
	private byte[] imagem;

	private List<ComentarioDTO> comentarios;

	private UsuarioDTO usuario;

}
