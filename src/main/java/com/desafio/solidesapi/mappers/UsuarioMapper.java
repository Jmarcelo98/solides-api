package com.desafio.solidesapi.mappers;

import com.desafio.solidesapi.mappers.generic.GenericMapper;
import com.desafio.solidesapi.model.dto.UsuarioDTO;
import com.desafio.solidesapi.model.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper extends GenericMapper<Usuario, UsuarioDTO> {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

}
