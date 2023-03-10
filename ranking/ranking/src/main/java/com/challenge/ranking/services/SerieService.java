package com.challenge.ranking.services;

import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.json.UserRest;

public interface SerieService {
    SerieRest createSerie(SerieRest serieRest) throws RankingException;

    SerieRest findById(Long id) throws RankingException;

    void updateAverageScore(Long serieId, float score) throws RankingException;
}