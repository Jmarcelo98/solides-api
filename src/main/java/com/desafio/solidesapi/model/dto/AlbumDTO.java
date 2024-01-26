package com.desafio.solidesapi.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

	private Integer id;

	private String titulo;

	private List<FotoDTO> fotos;

	private UsuarioDTO usuario;

}
