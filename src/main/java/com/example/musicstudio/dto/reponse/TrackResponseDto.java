package com.example.musicstudio.dto.reponse;

public record TrackResponseDto(
        Long id,
        String name,
        int duration,
        String genre,
        String albomTitle
) {
}
