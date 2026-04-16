package com.example.musicstudio.repository;

import com.example.musicstudio.model.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository <TrackEntity, Long> {

    List<TrackEntity> findByNameContainingIgnoreCase(String name);
    List<TrackEntity> findByAlbumId(long id);
}
