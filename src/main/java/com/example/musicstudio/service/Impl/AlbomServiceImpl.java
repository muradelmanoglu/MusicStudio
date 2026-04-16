package com.example.musicstudio.service.Impl;

import com.example.musicstudio.dto.reponse.AlbomResponseDto;
import com.example.musicstudio.dto.requast.AlbomRequestDto;
import com.example.musicstudio.exception.AlbomNotFoundException;
import com.example.musicstudio.mapper.AlbomMapper;
import com.example.musicstudio.model.AlbomEntity;
import com.example.musicstudio.repository.AlbomRepository;
import com.example.musicstudio.service.AlbomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbomServiceImpl implements AlbomService {

    private final AlbomRepository albomRepository;
    private final AlbomMapper albomMapper;

    @Override
    public AlbomResponseDto createAlbom(AlbomRequestDto dto) {
        AlbomEntity entity = albomMapper.toEntity(dto);
        AlbomEntity saved = albomRepository.save(entity);
        return albomMapper.toDto(saved);
    }

    @Override
    public AlbomResponseDto updateAlbom(Long id, AlbomRequestDto dto) {
        // 1. DB-dən tap
        AlbomEntity entity = albomRepository.findById(id)
                .orElseThrow(() -> new AlbomNotFoundException("Albom tapılmadı, id: " + id));
        // 2. Mapper ilə update et
        albomMapper.updateAlbom(dto, entity);
        // 3. Save et
        AlbomEntity saved = albomRepository.save(entity);
        return albomMapper.toDto(saved);
    }

    @Override
    public AlbomResponseDto findById(Long id) {
        AlbomEntity entity = albomRepository.findById(id)
                .orElseThrow(() -> new AlbomNotFoundException("Albom tapılmadı, id: " + id));
        return albomMapper.toDto(entity);
    }

    @Override
    public Page<AlbomResponseDto> findAll(Pageable pageable) {
        return albomRepository.findAll(pageable)
                .map(albomMapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        AlbomEntity entity = albomRepository.findById(id)
                .orElseThrow(() -> new AlbomNotFoundException("Albom tapılmadı, id: " + id));
        albomRepository.delete(entity);
    }
}