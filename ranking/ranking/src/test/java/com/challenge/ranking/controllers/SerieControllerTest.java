package com.challenge.ranking.controllers;

import com.challenge.ranking.json.SerieRest;
import com.challenge.ranking.services.SerieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class SerieControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SerieService serieService;
    private List<SerieRest> SERIE_REST_LIST = new ArrayList<>();
    private SerieRest SERIE_REST_1 = new SerieRest();
    private SerieRest SERIE_REST_2 = new SerieRest();
    private String NAME_TEST1 = "test name";
    private String NAME_TEST2 = "test name2";
    @Before
    public void executedBefore() {
        SERIE_REST_1.setName(NAME_TEST1);
        SERIE_REST_2.setName(NAME_TEST2);
        SERIE_REST_LIST.add(SERIE_REST_1);
        SERIE_REST_LIST.add(SERIE_REST_2);
    }

    @Test
    public void whenCreateSerie_ThenReturnCreated () throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(SERIE_REST_1);
        given(serieService.createSerie(SERIE_REST_1)).willReturn(SERIE_REST_1);
        MockHttpServletResponse response = mvc.perform(post("/ranking/v1/series")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json))
                .andReturn()
                .getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
}
        @Test
    public void whenRetrieveSeriesListThenReturnTheList () throws Exception {
            Mockito.when(serieService.retrieveSerieScoreList()).thenReturn(SERIE_REST_LIST);
            MockHttpServletResponse response = mvc.perform(
                    get("/ranking/v1/series")
                    .accept(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse();
            assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }
    @Test
    public void whenRetrieveSerieScoreListThenReturnTheList () throws Exception {
        Mockito.when(serieService.retrieveSerieScoreList()).thenReturn(SERIE_REST_LIST);
        MockHttpServletResponse response = mvc.perform(
                        get("/ranking/v1/series/scores")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
        @After
        public void executedAfter() {
            SERIE_REST_LIST.clear();

    }
}
