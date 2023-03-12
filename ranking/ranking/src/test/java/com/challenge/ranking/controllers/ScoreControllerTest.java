package com.challenge.ranking.controllers;

import com.challenge.ranking.json.ScoreRest;
import com.challenge.ranking.services.ScoreService;
import com.challenge.ranking.services.SerieService;
import com.challenge.ranking.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@SpringBootTest
@AutoConfigureMockMvc
public class ScoreControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ScoreService scoreService;

    @MockBean
    private UserService userService;

    @MockBean
    private SerieService serieService;

    @Test
    public void whenCreateScore_ThenReturnCreated() throws Exception {
        ScoreRest scoreRest = new ScoreRest();
        scoreRest.setScore(1f);
        scoreRest.setSerieName("Aladin");
        scoreRest.setUserName("Miki");
        Float score = 1f;
        scoreRest.setScore(score);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(score);
        given(scoreService.createReview(score, 1L, 1L)).willReturn(scoreRest);
        MockHttpServletResponse response = mvc.perform(post("/ranking/v1/users/1/series/1/scores")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json))
                .andReturn()
                .getResponse();
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

}