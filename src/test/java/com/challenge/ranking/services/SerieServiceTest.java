package com.challenge.ranking.services;

import com.challenge.ranking.entites.Score;
import com.challenge.ranking.entites.Serie;
import com.challenge.ranking.entites.User;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.repositories.SerieRepository;
import com.challenge.ranking.services.impl.SerieServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class SerieServiceTest {

    @Mock
    private SerieRepository serieRepository;

    @InjectMocks
    private SerieServiceImpl serieService;
    private Serie SERIE = new Serie();
    private SerieRest SERIE_REST = new SerieRest();
    private Long SERIE_ID = 1L;
    private String SERIE_NAME = "serie name test";

    private List<Serie> SERIE_LIST = new ArrayList<>();

    private List<SerieRest> SERIE_REST_LIST = new ArrayList<>();

    private Score SCORE_ENTITY = new Score();

    private List<Score> SCORE_LIST = new ArrayList<>();

    private User USER = new User();


    private Float SCORE = 5F;
    @Before
    public void executedBefore() {
        SERIE.setAverageScore(SCORE);
        SERIE.setName(SERIE_NAME);
        SERIE.setId(SERIE_ID);
        SERIE_REST.setName(SERIE_NAME);
        SERIE_REST.setId(SERIE_ID);
        SERIE_REST.setAverageScore(SCORE);
    }

    @Test
    public void whenFindByIdTheReturnTheSerie () throws RankingException {
        Mockito.when(serieRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SERIE));
        SerieRest response = serieService.findById(SERIE_ID);
        assertThat(response).isNotNull();
        assertThat(response.getName()).isSameAs(SERIE.getName());
        Mockito.verify(serieRepository).findById(SERIE_ID);
    }
    @Test
    public void wheRetrieveSerieListThenReturnSeriesListSortedByScore () throws  RankingException {
        SERIE_REST_LIST.add(SERIE_REST);
        SERIE_LIST.add(SERIE);
        Mockito.when(serieRepository.findAllByOrderByAverageScoreDesc()).thenReturn(SERIE_LIST);
        List<SerieRest> response = serieService.retrieveSeriesListSortedByScore();
        assertThat(response).isNotNull();
        assertThat(response.get(0).getName()).isSameAs(SERIE.getName());
        Mockito.verify(serieRepository).findAllByOrderByAverageScoreDesc();

    }

    @Test
    public void whenRetrieveSerieScoreThenReturnTheList () throws RankingException {
        USER.setName("name");
        SCORE_ENTITY.setSerie(SERIE);
        SCORE_ENTITY.setUser(USER);
        SCORE_ENTITY.setScore(SCORE);
        SCORE_LIST.add(SCORE_ENTITY);
        SERIE.setScoreList(SCORE_LIST);
        SERIE_LIST.add(SERIE);
        Mockito.when(serieRepository.findAll()).thenReturn(SERIE_LIST);
        List<SerieRest> response = serieService.retrieveSerieScoreList();
        assertThat(response).isNotNull();
        assertThat(response.get(0).getName()).isSameAs(SERIE.getName());
        assertThat(response.size()).isEqualTo(1);
        Mockito.verify(serieRepository).findAll();
    }
    @Test
    public void whenCreateSerieReturnTheSerieCreated () throws RankingException {
        given(serieRepository.save(Mockito.any())).willReturn(SERIE);
        SerieRest response = serieService.createSerie(SERIE_REST);
        assertThat(response).isNotNull();
        assertThat(response.getName()).isSameAs(SERIE.getName());
        }

        @Test
        public void updateAverageScoreTest () throws RankingException {
        Mockito.when(serieRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(SERIE));
        given(serieRepository.save(Mockito.any())).willReturn(SERIE);
        serieService.updateAverageScore(1L,1F);
        Mockito.verify(serieRepository).findById(Mockito.anyLong());
        }

    @After
    public void executedAfter() {
        SCORE_LIST.clear();
        SERIE_REST_LIST.clear();
        SERIE_LIST.clear();
    }
}
