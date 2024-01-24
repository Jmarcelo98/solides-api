package com.desafio.solidesapi.config.security;

import com.desafio.solidesapi.model.entities.Usuario;
import com.desafio.solidesapi.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AppContextHolder {

    private final UsuarioService usuarioService;

    public Usuario getUsuario(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usuarioService.buscarUsuarioLogado(email);
    }
}