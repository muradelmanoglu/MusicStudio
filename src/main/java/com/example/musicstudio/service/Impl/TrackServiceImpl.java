package com.example.musicstudio.service.Impl;

import com.example.musicstudio.dto.reponse.TrackResponseDto;
import com.example.musicstudio.dto.requast.TrackRequestDto;
import com.example.musicstudio.exception.AlbomNotFoundException;
import com.example.musicstudio.exception.TrackNotFoundException;
import com.example.musicstudio.mapper.TrackMapper;
import com.example.musicstudio.model.AlbomEntity;
import com.example.musicstudio.model.TrackEntity;
import com.example.musicstudio.repository.AlbomRepository;
import com.example.musicstudio.repository.TrackRepository;
import com.example.musicstudio.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final AlbomRepository albomRepository;
    private final TrackMapper trackMapper;

    @Override
    public TrackResponseDto createTrack(TrackRequestDto dto) {
        AlbomEntity albom = albomRepository.findById(dto.albomId())
                .orElseThrow(() -> new AlbomNotFoundException("Albom tapılmadı, id: " + dto.albomId()));

        TrackEntity entity = trackMapper.toEntity(dto);
        entity.setAlbum(albom);

        TrackEntity saved = trackRepository.save(entity);
        return trackMapper.toDto(saved);
    }

    @Override
    public TrackResponseDto updateTrack(Long id, TrackRequestDto dto) {
        TrackEntity entity = trackRepository.findById(id)
                .orElseThrow(() -> new TrackNotFoundException("Track tapılmadı, id: " + id));

        trackMapper.updateTrack(dto, entity);

        if (dto.albomId() != null && !dto.albomId().equals(entity.getAlbum().getId())) {
            AlbomEntity newAlbom = albomRepository.findById(dto.albomId())
                    .orElseThrow(() -> new AlbomNotFoundException("Albom tapılmadı, id: " + dto.albomId()));
            entity.setAlbum(newAlbom);
        }
        TrackEntity saved = trackRepository.save(entity);
        return trackMapper.toDto(saved);
    }

    @Override
    public TrackResponseDto findById(Long id) {
        TrackEntity entity = trackRepository.findById(id)
                .orElseThrow(() -> new TrackNotFoundException("Track tapılmadı, id: " + id));
        return trackMapper.toDto(entity);
    }

    @Override
    public Page<TrackResponseDto> findAll(Pageable pageable) {
        return trackRepository.findAll(pageable)
                .map(trackMapper::toDto);
    }

    @Override
    public void deleteTrack(Long id) {
        TrackEntity entity = trackRepository.findById(id)
                .orElseThrow(() -> new TrackNotFoundException("Track tapılmadı, id: " + id));
        trackRepository.delete(entity);
    }
}
