package com.desafio.solidesapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String login;

	private List<PostDTO> posts;

	private List<AlbumDTO> albuns;



}
