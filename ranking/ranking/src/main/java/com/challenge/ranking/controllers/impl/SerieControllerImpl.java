package com.challenge.ranking.controllers.impl;

import com.challenge.ranking.controllers.SerieController;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.responses.RankingResponse;
import com.challenge.ranking.services.SerieService;
import com.challenge.ranking.utils.constants.CommonConstants;
import com.challenge.ranking.utils.constants.RestConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SERIE)
public class SerieControllerImpl  implements SerieController {
    @Autowired
    SerieService serieService;
    @Override
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RankingResponse<SerieRest> createSerie(@RequestBody @Valid SerieRest serieRest) throws RankingException {
        return new RankingResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), CommonConstants.OK,
                serieService.createSerie(serieRest));
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RankingResponse<List<SerieRest>> retrieveSeriesListSortedByScore() throws RankingException {
        return new RankingResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                serieService.retrieveSeriesListSortedByScore());
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_SCORE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RankingResponse<List<SerieRest>> retrieveSerieScoreList() throws RankingException {
        return new RankingResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                serieService.retrieveSerieScoreList());
    }
}