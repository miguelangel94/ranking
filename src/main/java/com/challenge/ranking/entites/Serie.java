package com.challenge.ranking.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "SERIE",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "STREAMING_PLATFORM",  nullable = false)
    private String streamingPlatform;

    @Column(name = "COVER",  nullable = false)
    private String cover;

    @Column(name = "SINOPSIS",  nullable = false)
    private String sinopsis;

    @Column(name = "AVERAGE_SCORE")
    private Float averageScore;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serie")
    private List<Score> scoreList;
}
