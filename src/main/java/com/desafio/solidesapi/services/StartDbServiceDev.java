package com.desafio.solidesapi.services;

import java.util.Arrays;

import com.desafio.solidesapi.model.entities.Album;
import com.desafio.solidesapi.model.entities.Foto;
import com.desafio.solidesapi.model.entities.Post;
import com.desafio.solidesapi.repositories.AlbumRepository;
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

	public void instanciarDados() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		var usuario1 = Usuario.builder().id(null).login("joao").senha(encoder.encode("123")).build();
		var usuario2 = Usuario.builder().id(null).login("tauany").senha(encoder.encode("123")).build();

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2));

		var post1Usuario1 = Post.builder().id(null).texto("Texto de teste 1, primeiro texto do usuario 1").imagem(null).link("https://www.google.com/").usuario(usuario1).build();
		var post2Usuario1 = Post.builder().id(null).texto("Estamos testando novamente, segundo do usuario 1").imagem(null).link("https://www.lipsum.com/").usuario(usuario1).build();
		var post3Usuario1 = Post.builder().id(null).texto("Ultimo teste do usuario 1").imagem(null).usuario(usuario1).link(null).build();
		var post1Usuario2 = Post.builder().id(null).texto("Aqui é um teste 1 do usuario 2").imagem(null).usuario(usuario2).link("https://www.psafe.com/dfndr-lab/pt-br/").build();
		var post2Usuario2 = Post.builder().id(null).texto("Esse é o ultimo teste do usuario 2").imagem(null).link("").usuario(usuario2).link("https://www.devmedia.com.br/testlink-gerenciando-atividades-de-teste/32281").build();

		postRepository.saveAll(Arrays.asList(post1Usuario1, post1Usuario2, post3Usuario1, post2Usuario1, post2Usuario2));

		var album1Usuario1 = Album.builder().id(null).titulo("A vida é bela! A1-1").usuario(usuario1).build();
		var album2Usuario1 = Album.builder().id(null).titulo("A importância do consumo de água A2-1").usuario(usuario1).build();
		var album1Usuario2 = Album.builder().id(null).titulo("A grande final da Copa SP Futebol Jr A1-2").usuario(usuario2).build();

		albumRepository.saveAll(Arrays.asList(album1Usuario1, album2Usuario1, album1Usuario2));

		var foto1Album1Usuario1 = Foto.builder().id(null).imagem(null).album(album1Usuario1).build();
		var foto2Album1Usuario1 = Foto.builder().id(null).imagem(null).album(album1Usuario1).build();
		var foto1Album2Usuario2 = Foto.builder().id(null).imagem(null).album(album1Usuario2).build();

		fotoRepository.saveAll(Arrays.asList(foto1Album1Usuario1, foto2Album1Usuario1, foto1Album2Usuario2));

	}

}
