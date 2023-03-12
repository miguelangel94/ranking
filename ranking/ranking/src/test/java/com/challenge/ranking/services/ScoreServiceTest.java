package com.challenge.ranking.services;

import com.challenge.ranking.entites.Score;
import com.challenge.ranking.entites.Serie;
import com.challenge.ranking.entites.User;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.ScoreRest;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.json.UserRest;
import com.challenge.ranking.repositories.ScoreRepository;
import com.challenge.ranking.repositories.SerieRepository;
import com.challenge.ranking.repositories.UserRepository;
import com.challenge.ranking.services.impl.ScoreServiceImpl;
import com.challenge.ranking.services.impl.SerieServiceImpl;
import com.challenge.ranking.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ScoreServiceTest {

    @Mock
    private ScoreRepository scoreRepository;

    @Mock
    private SerieRepository serieRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SerieServiceImpl serieService;

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private ScoreServiceImpl scoreService;

    private Serie SERIE = new Serie();
    private SerieRest SERIE_REST = new SerieRest();
    private Long SERIE_ID = 1L;

    private Long USER_ID = 1L;
    private String SERIE_NAME = "serie name test";

    private Score SCORE_ENTITY = new Score();

    private List<Score> SCORE_LIST = new ArrayList<>();

    private UserRest USER_REST = new UserRest();

    private User USER = new User();

    private Float SCORE = 5F;
    @Test
    public void whenCreateReviewThenReturnTheScoreCreated() throws RankingException {
        SERIE.setAverageScore(SCORE);
        SERIE.setName(SERIE_NAME);
        SERIE.setId(SERIE_ID);
        USER_REST.setName(SERIE_NAME);
        USER_REST.setId(SERIE_ID);
        SERIE_REST.setName(SERIE_NAME);
        SERIE_REST.setId(SERIE_ID);
        SERIE_REST.setAverageScore(SCORE);
        Mockito.when(userService.findById(Mockito.anyLong())).thenReturn(USER_REST);
        Mockito.when(serieService.findById(Mockito.anyLong())).thenReturn(SERIE_REST);
        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(USER));
        Mockito.when(serieRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SERIE));
        Mockito.when(scoreRepository.findBySerieId(Mockito.anyLong())).thenReturn(SCORE_LIST);
        Mockito.when(scoreRepository.save(Mockito.any())).thenReturn(SCORE_ENTITY);
        ScoreRest response = scoreService.createReview(SCORE, USER_ID, SERIE_ID);
        assertThat(response).isNotNull();
        assertThat(response.getSerieName()).isSameAs(SERIE_NAME);
    }
}
