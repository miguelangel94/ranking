package com.challenge.ranking.utils.converters;

import com.challenge.ranking.entites.Serie;
import com.challenge.ranking.json.SerieRest;

public class SerieConverter {

    public static Serie mapToEntity (SerieRest serieRest) {
        Serie serie = new Serie();
        serie.setId(serieRest.getId());
        serie.setName(serieRest.getName());
        serie.setCover(serieRest.getCover());
        serie.setSinopsis(serieRest.getSinopsis());
        serie.setStreamingPlatform(serieRest.getStreamingPlatform());
        return serie;
    }

    public static  SerieRest mapToRest (Serie serie){
    SerieRest serieRest = new SerieRest();

        serieRest.setId(serie.getId());
        serieRest.setName(serie.getName());
        serieRest.setCover(serie.getCover());
        serieRest.setSinopsis(serie.getSinopsis());
        serieRest.setStreamingPlatform(serie.getStreamingPlatform());
        return serieRest;
    }
}
