package com.desafio.solidesapi.model.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Lob
	//	@NotNull - descomentar ao criar front-end
	private byte[] imagem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_album")
	private Album album;

}
