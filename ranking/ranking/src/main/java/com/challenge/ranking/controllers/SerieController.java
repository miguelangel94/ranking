package com.challenge.ranking.controllers;

import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.responses.RankingResponse;

import java.util.List;

public interface SerieController {
    RankingResponse<SerieRest> createSerie(SerieRest serieRest) throws RankingException;

    RankingResponse<List<SerieRest>> retrieveSeriesListSortedByScore () throws  RankingException;

    RankingResponse<List<SerieRest>> retrieveSerieScoreList() throws RankingException;

}
