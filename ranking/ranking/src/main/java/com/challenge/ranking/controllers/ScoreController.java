package com.challenge.ranking.controllers;

import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.ScoreRest;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.responses.RankingResponse;

public interface ScoreController {
    RankingResponse<ScoreRest> createReview(Long userId, Long serieId, float score) throws RankingException;

}
