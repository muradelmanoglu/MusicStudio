package com.example.musicstudio.mapper;

import com.example.musicstudio.dto.reponse.TrackResponseDto;
import com.example.musicstudio.dto.requast.TrackRequestDto;
import com.example.musicstudio.model.TrackEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TrackMapper {

    @Mapping(source = "album.title", target = "albomTitle")
    TrackResponseDto toDto(TrackEntity trackEntity);
    TrackEntity toEntity(TrackRequestDto trackRequestDto);

    void  updateTrack(TrackRequestDto trackRequestDto, @MappingTarget TrackEntity trackEntity);
}
