package com.desafio.solidesapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.desafio.solidesapi.mappers.generic.GenericMapper;
import com.desafio.solidesapi.model.dto.ComentarioDTO;
import com.desafio.solidesapi.model.entities.Comentario;

@Mapper
public interface ComentarioMapper extends GenericMapper<Comentario, ComentarioDTO> {

	ComentarioMapper INSTANCE = Mappers.getMapper(ComentarioMapper.class);

}
