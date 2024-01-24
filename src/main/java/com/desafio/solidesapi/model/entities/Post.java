package com.desafio.solidesapi.model.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String texto;

	private String link;

	@Lob
//	@NotNull - descomentar ao criar front-end
	private byte[] imagem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	private Usuario usuario;

}
