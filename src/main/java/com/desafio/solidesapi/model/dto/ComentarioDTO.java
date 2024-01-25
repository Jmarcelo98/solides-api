package com.desafio.solidesapi.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String comentario;

	private LocalDate dataCriacao;

	private UsuarioDTO usuario;

}
