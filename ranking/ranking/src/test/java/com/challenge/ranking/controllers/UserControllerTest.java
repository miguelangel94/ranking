package com.challenge.ranking.controllers;

import com.challenge.ranking.json.UserRest;
import com.challenge.ranking.services.UserService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void whenRetrieveUsers_shouldReturnAllUserList() throws Exception {
        List<UserRest> USER_LIST = new ArrayList<>();
        UserRest USER_1 = new UserRest();
        UserRest USER_2 = new UserRest();
        String NAME_TEST1 = "test name";
        String NAME_TEST2 = "test name2";
        USER_1.setName(NAME_TEST1);
        USER_2.setName(NAME_TEST2);
        USER_LIST.add(USER_1);
        USER_LIST.add(USER_2);
        Mockito.when(userService.getUsers()).thenReturn(USER_LIST);
        MockHttpServletResponse response = mvc.perform(
                get("/ranking/v1/users")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

}
