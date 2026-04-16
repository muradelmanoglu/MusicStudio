package com.example.musicstudio.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "track")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    int duration;

    String genre;

    @ManyToOne
            @JoinColumn(name = "albom_id")
    AlbomEntity album;

}
