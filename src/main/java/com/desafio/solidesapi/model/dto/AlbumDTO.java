package com.desafio.solidesapi.model.dto;

import com.desafio.solidesapi.model.entities.Foto;
import com.desafio.solidesapi.model.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDTO {

	private Integer id;

	private String titulo;

	private List<FotoDTO> fotos;

//	private Usuario usuario;

}
