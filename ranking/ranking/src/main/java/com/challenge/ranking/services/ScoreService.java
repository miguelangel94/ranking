package com.challenge.ranking.services;

import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.ScoreRest;
import com.challenge.ranking.json.SerieRest;

import java.util.List;

public interface ScoreService {
    ScoreRest createReview(float score, Long userId, Long serieId) throws RankingException;
}
