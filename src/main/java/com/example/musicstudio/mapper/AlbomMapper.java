package com.example.musicstudio.mapper;

import com.example.musicstudio.dto.reponse.AlbomResponseDto;
import com.example.musicstudio.dto.requast.AlbomRequestDto;
import com.example.musicstudio.model.AlbomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AlbomMapper {

    AlbomResponseDto toDto(AlbomEntity albomEntity);
    AlbomEntity toEntity(AlbomRequestDto albomRequestDto);
    void updateAlbom(AlbomRequestDto albomRequestDto, @MappingTarget  AlbomEntity albomEntity);



}
