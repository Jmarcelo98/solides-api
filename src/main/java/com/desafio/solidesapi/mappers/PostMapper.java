package com.desafio.solidesapi.mappers;

import com.desafio.solidesapi.mappers.generic.GenericMapper;
import com.desafio.solidesapi.model.dto.PostDTO;
import com.desafio.solidesapi.model.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper extends GenericMapper<Post, PostDTO> {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

}
