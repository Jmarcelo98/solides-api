package com.desafio.solidesapi.mappers;

import com.desafio.solidesapi.mappers.generic.GenericMapper;
import com.desafio.solidesapi.model.dto.AlbumDTO;
import com.desafio.solidesapi.model.entities.Album;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumMapper extends GenericMapper<Album, AlbumDTO> {

    AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);

}
