package com.example.musicstudio.repository;

import com.example.musicstudio.model.AlbomEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbomRepository extends JpaRepository<AlbomEntity, Long> {

        List<AlbomEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
