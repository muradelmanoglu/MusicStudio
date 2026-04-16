package com.example.musicstudio.service;

import com.example.musicstudio.dto.reponse.AlbomResponseDto;
import com.example.musicstudio.dto.requast.AlbomRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlbomService {

    AlbomResponseDto createAlbom(AlbomRequestDto dto);
    AlbomResponseDto updateAlbom(Long id, AlbomRequestDto dto);
    AlbomResponseDto findById(Long id);
    Page<AlbomResponseDto> findAll(Pageable pageable);
    void deleteById(Long id);

}
