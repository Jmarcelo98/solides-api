package com.desafio.solidesapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FotoDTO {

	private Integer id;

	private byte[] imagem;

//	private Album album;

}
