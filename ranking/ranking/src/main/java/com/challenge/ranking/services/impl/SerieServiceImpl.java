package com.challenge.ranking.services.impl;

import com.challenge.ranking.entites.Serie;
import com.challenge.ranking.exceptions.InternalServerErrorException;
import com.challenge.ranking.exceptions.NotFoundException;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.repositories.SerieRepository;
import com.challenge.ranking.services.SerieService;
import com.challenge.ranking.utils.constants.ExceptionConstants;
import com.challenge.ranking.utils.converters.SerieConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements SerieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerieServiceImpl.class);
    @Autowired
    SerieRepository serieRepository;

    @Override
    public SerieRest createSerie(SerieRest serieRest) throws RankingException {

        try {
            return SerieConverter.mapToRest(serieRepository.save(SerieConverter.mapToEntity(serieRest)));
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public SerieRest findById(Long id) throws RankingException {
        Serie serie;
        serie = serieRepository.findById(id).orElseThrow(() -> new NotFoundException("error, serie not found"));
        return SerieConverter.mapToRest(serie);
    }
    @Override
    public void updateAverageScore (Long serieId, float score) throws RankingException{
        Serie serie;
        try {
            serie = serieRepository.findById(serieId).orElseThrow(() -> new NotFoundException("error, serie not found"));
            serie.setAverageScore(score);
            serieRepository.save(serie);
        } catch (final Exception e) {
            LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
            throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<SerieRest> retrieveSeriesListSortedByScore() throws RankingException {
        return serieRepository.findAllByOrderByAverageScoreDesc().stream()
                .map(SerieConverter::mapToRest)
                .collect(Collectors.toList());
    }

    @Override
    public List<SerieRest> retrieveSerieScoreList() throws RankingException {
        return serieRepository.findAll().stream().map(serie -> SerieConverter.mapToRestWithScore(serie)).collect(Collectors.toList());
    }
}

