package com.challenge.ranking.repositories;

import com.challenge.ranking.entites.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findAllByOrderByAverageScoreDesc();
}
