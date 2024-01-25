package com.desafio.solidesapi.services;

import java.time.LocalDate;
import java.util.Arrays;

import com.desafio.solidesapi.model.entities.Album;
import com.desafio.solidesapi.model.entities.Comentario;
import com.desafio.solidesapi.model.entities.Foto;
import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.repositories.AlbumRepository;
import com.desafio.solidesapi.repositories.ComentarioRepository;
import com.desafio.solidesapi.repositories.FotoRepository;
import com.desafio.solidesapi.repositories.PostRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StartDbServiceDev {

	private final UsuarioRepository usuarioRepository;

	private final PostRepository postRepository;

	private final AlbumRepository albumRepository;

	private final FotoRepository fotoRepository;

	private final ComentarioRepository comentarioRepository;

	public void instanciarDados() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		var usuario1 = Usuario.builder().id(null).login("joao").senha(encoder.encode("1234")).build();
		var usuario2 = Usuario.builder().id(null).login("lucas").senha(encoder.encode("1234")).build();

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

		var post1Usuario1 = Post.builder().id(null).texto(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque nisl urna, laoreet eu dignissim varius, condimentum quis nulla. Nullam imperdiet efficitur eros, a vestibulum sapien")
				.imagem(null).link("https://www.lipsum.com/").usuario(usuario1).dataCriacao(LocalDate.now()).build();
		var post2Usuario1 = Post.builder().id(null).texto("Final da Copa São Paulo Futebol Júnior 2024").imagem(null)
				.link("https://ge.globo.com/futebol/copa-sp-de-futebol-junior/noticia/2024/01/25/corinthians-x-cruzeiro-onde-assistir-ao-vivo-horario-e-escalacoes-da-final-da-copinha.ghtml")
				.usuario(usuario1).dataCriacao(LocalDate.now()).build();
		var post3Usuario1 = Post.builder().id(null).texto("Sólides Tangerino").imagem(null).usuario(usuario1)
				.link("https://tangerino.com.br/").dataCriacao(LocalDate.now()).build();

		var post1Usuario2 = Post.builder().id(null).texto("O Brasil").imagem(null).usuario(usuario2)
				.link("https://brasilescola.uol.com.br/geografia/pais-brasil.htm").dataCriacao(LocalDate.now()).build();

		var post2Usuario2 = Post.builder().id(null).texto("Java 17").imagem(null)
				.link("https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html").usuario(usuario2)
				.dataCriacao(LocalDate.now()).build();

		var post2Usuario3 = Post.builder().id(null).texto("Angular Material v.15").imagem(null).usuario(usuario2)
				.link("https://v15.material.angular.io/").dataCriacao(LocalDate.now()).build();

		postRepository.saveAll(Arrays.asList(post1Usuario1, post1Usuario2, post3Usuario1, post2Usuario1, post2Usuario2,
				post2Usuario3));

		var comentario1Usuario1NoPost2 = Comentario.builder().id(null).comentario("O país mais bonito!")
				.post(post1Usuario2).usuario(usuario1).dataCriacao(LocalDate.now()).build();

		var comentario1Usuario2NoPost2 = Comentario.builder().id(null).dataCriacao(LocalDate.now())
				.comentario("Eu concordo").post(post1Usuario2).usuario(usuario2).build();

		var comentario1Usuario2NoPost3 = Comentario.builder().id(null).dataCriacao(LocalDate.now())
				.comentario("Ajuda muito! Juntamente com o Bootstrap").post(post2Usuario3).usuario(usuario1).build();

		comentarioRepository.saveAll(
				Arrays.asList(comentario1Usuario1NoPost2, comentario1Usuario2NoPost2, comentario1Usuario2NoPost3));

		var album1Usuario1 = Album.builder().id(null).titulo("A vida é bela! ").usuario(usuario1).build();
		var album2Usuario1 = Album.builder().id(null).titulo("A importância do consumo de água ").usuario(usuario1)
				.build();
		var album1Usuario2 = Album.builder().id(null).titulo("A grande final da Copa SP Futebol Jr").usuario(usuario2)
				.build();

		albumRepository.saveAll(Arrays.asList(album1Usuario1, album2Usuario1, album1Usuario2));

		var foto1Album1Usuario1 = Foto.builder().id(null).imagem(null).album(album1Usuario1).build();
		var foto2Album1Usuario1 = Foto.builder().id(null).imagem(null).album(album1Usuario1).build();
		var foto1Album2Usuario2 = Foto.builder().id(null).imagem(null).album(album1Usuario2).build();

		fotoRepository.saveAll(Arrays.asList(foto1Album1Usuario1, foto2Album1Usuario1, foto1Album2Usuario2));

	}

}
