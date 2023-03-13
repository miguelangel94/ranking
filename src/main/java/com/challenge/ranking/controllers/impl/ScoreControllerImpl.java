package com.challenge.ranking.controllers.impl;

import com.challenge.ranking.controllers.ScoreController;
import com.challenge.ranking.controllers.SerieController;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.ScoreRest;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.responses.RankingResponse;
import com.challenge.ranking.services.ScoreService;
import com.challenge.ranking.services.SerieService;
import com.challenge.ranking.utils.constants.CommonConstants;
import com.challenge.ranking.utils.constants.RestConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CREATE_SCORE)
public class ScoreControllerImpl implements ScoreController {
    @Autowired
    ScoreService scoreService;
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RankingResponse<ScoreRest> createReview(@PathVariable Long userId, @PathVariable Long serieId, @RequestBody float score) throws RankingException {
        return new RankingResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), CommonConstants.OK,
                scoreService.createReview(score,userId, serieId));
    }
}