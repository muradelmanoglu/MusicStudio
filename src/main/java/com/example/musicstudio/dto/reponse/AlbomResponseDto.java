package com.example.musicstudio.dto.reponse;

import java.util.List;

public record AlbomResponseDto (
        Long id,
        String title,
        String artistName,
        int releaseYear,
        List<TrackResponseDto> tracks
) {}
