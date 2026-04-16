package com.example.musicstudio.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "albom")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlbomEntity {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String artistName;

    int releaseYear;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL,  orphanRemoval = true)
    List<TrackEntity> tracks;


}
