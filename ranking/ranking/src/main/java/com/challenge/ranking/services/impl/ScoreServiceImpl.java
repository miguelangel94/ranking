package com.challenge.ranking.services.impl;

import com.challenge.ranking.entites.Score;
import com.challenge.ranking.exceptions.InternalServerErrorException;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.ScoreRest;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.json.UserRest;
import com.challenge.ranking.repositories.ScoreRepository;
import com.challenge.ranking.services.ScoreService;
import com.challenge.ranking.services.SerieService;
import com.challenge.ranking.services.UserService;
import com.challenge.ranking.utils.constants.ExceptionConstants;
import com.challenge.ranking.utils.converters.ScoreConverter;
import com.challenge.ranking.utils.converters.SerieConverter;
import com.challenge.ranking.utils.converters.UserConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements ScoreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScoreServiceImpl.class);
    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    UserService userService;

    @Autowired
    SerieService serieService;

    @Override
    public ScoreRest createReview(float score, Long userId, Long serieId) throws RankingException {
        verifyTheScore(score);

        ScoreServiceImpl scoreService = new ScoreServiceImpl();
        UserRest userRest = userService.findById(userId);
        SerieRest serieRest = serieService.findById(serieId);
        Score scoreEntity = ScoreConverter.mapToEntity(score, userRest, serieRest);

        try {

            List<Float> scoreList=  scoreRepository.findBySerieId(serieId).stream()
                    .map(Score::getScore)
                    .collect(Collectors.toList());
            updateAverageScoreSerie(serieId, scoreList, score);
            scoreRepository.save(scoreEntity);
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return ScoreConverter.mapToRest(score, userRest.getName(), serieRest.getName());
    }

    public Float scoreAverageCalculator (List<Float> scoreList)  {

        float average = 0f;
        for (Float aFloat : scoreList) {
            average = average + aFloat;
        }
        average = average/scoreList.size();

        return  average;
    }

    public void updateAverageScoreSerie(Long serieId, List<Float> scoreList, Float newScore) throws RankingException {
        scoreList.add(newScore);
        Float average = scoreAverageCalculator(scoreList);
            serieService.updateAverageScore(serieId, average);
    }

    void verifyTheScore(float score) throws RankingException {
        if (score > 10 || score < 0){
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR, ExceptionConstants.INVALID_SCORE_MESSAGE);

        }
    }
}

