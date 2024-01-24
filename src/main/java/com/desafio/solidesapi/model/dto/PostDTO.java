package com.desafio.solidesapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

	private Integer id;

	private String texto;

	private String link;

	@Lob
	private byte[] imagem;

//	private UsuarioDTO usuario;

}
