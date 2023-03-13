package com.challenge.ranking.utils.converters;

import com.challenge.ranking.entites.Score;
import com.challenge.ranking.json.ScoreRest;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.json.UserRest;

public class ScoreConverter {
    public static ScoreRest mapToRest (float score, String userName, String serieName){
        ScoreRest scoreRest = new ScoreRest();
        scoreRest.setScore(score);
        scoreRest.setSerieName(serieName);
        scoreRest.setUserName(userName);
        return scoreRest;
    }

    public static  Score mapToEntity (float score, UserRest userRest, SerieRest serieRest) {
        Score scoreEntity = new Score();
        scoreEntity.setScore(score);
        scoreEntity.setUser(UserConverter.mapToEntity(userRest));
        scoreEntity.setSerie(SerieConverter.mapToEntity(serieRest));
        return  scoreEntity;
    }
}
