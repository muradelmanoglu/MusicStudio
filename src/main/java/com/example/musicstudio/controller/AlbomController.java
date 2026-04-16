package com.example.musicstudio.controller;

import com.example.musicstudio.dto.reponse.AlbomResponseDto;
import com.example.musicstudio.dto.requast.AlbomRequestDto;
import com.example.musicstudio.service.AlbomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alboms")
@RequiredArgsConstructor
public class AlbomController {

    private final AlbomService albomService;

    @PostMapping
    public ResponseEntity<AlbomResponseDto> create(@RequestBody AlbomRequestDto dto) {
        AlbomResponseDto created = albomService.createAlbom(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbomResponseDto> update(@PathVariable Long id,
                                                   @RequestBody AlbomRequestDto dto) {
        AlbomResponseDto updated = albomService.updateAlbom(id, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<Page<AlbomResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(albomService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbomResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(albomService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        albomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
