package com.example.musicstudio.controller;

import com.example.musicstudio.dto.reponse.TrackResponseDto;
import com.example.musicstudio.dto.requast.TrackRequestDto;
import com.example.musicstudio.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracks")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;

    // POST /tracks
    @PostMapping
    public ResponseEntity<TrackResponseDto> create(@RequestBody TrackRequestDto dto) {
        TrackResponseDto created = trackService.createTrack(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT /tracks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TrackResponseDto> update(@PathVariable Long id,
                                                   @RequestBody TrackRequestDto dto) {
        TrackResponseDto updated = trackService.updateTrack(id, dto);
        return ResponseEntity.ok(updated);
    }

    // GET /tracks?page=0&size=10
    @GetMapping
    public ResponseEntity<Page<TrackResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(trackService.findAll(pageable));
    }

    // GET /tracks/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TrackResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(trackService.findById(id));
    }

    // DELETE /tracks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trackService.deleteTrack(id);
        return ResponseEntity.noContent().build();
    }
}