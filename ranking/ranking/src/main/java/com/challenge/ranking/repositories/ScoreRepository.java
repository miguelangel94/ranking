package com.challenge.ranking.repositories;

import com.challenge.ranking.entites.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    List<Score> findBySerieId (Long serieId);
}
