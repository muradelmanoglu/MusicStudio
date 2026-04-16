package com.example.musicstudio.service;

import com.example.musicstudio.dto.reponse.TrackResponseDto;
import com.example.musicstudio.dto.requast.TrackRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TrackService {

    TrackResponseDto createTrack(TrackRequestDto dto);
    TrackResponseDto updateTrack(Long id, TrackRequestDto dto);
    TrackResponseDto findById(Long id);
    Page<TrackResponseDto> findAll(Pageable pageable);
    void deleteTrack(Long id);
}
