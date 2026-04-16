package com.example.musicstudio.dto.requast;

public record TrackRequestDto(
        String name,
        int duration,
        String genre,
        Long albomId
) {
}
