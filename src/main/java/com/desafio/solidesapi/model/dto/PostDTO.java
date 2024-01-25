package com.desafio.solidesapi.model.dto;

import java.time.LocalDate;

import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

	private Integer id;

	private String texto;

	private String link;
	
	private LocalDate dataCriacao;

	@Lob
	private byte[] imagem;

//	private UsuarioDTO usuario;

}
