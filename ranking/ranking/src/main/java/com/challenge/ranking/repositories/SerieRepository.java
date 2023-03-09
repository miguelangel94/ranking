package com.challenge.ranking.repositories;

import com.challenge.ranking.entites.Serie;
import com.challenge.ranking.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
}
