package com.challenge.ranking.services;

import com.challenge.ranking.entites.User;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.UserRest;
import com.challenge.ranking.repositories.UserRepository;
import com.challenge.ranking.services.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void whenRetrieveUsers_shouldReturnAllUserList() throws RankingException {
        List<User> USER_LIST = new ArrayList<>();
        User USER_1 = new User();
        User USER_2 = new User();
        String NAME_TEST1 = "test name";
        String NAME_TEST2 = "test name2";
        USER_1.setName(NAME_TEST1);
        USER_2.setName(NAME_TEST2);
        USER_LIST.add(USER_1);
        USER_LIST.add(USER_2);
        Mockito.when((userRepository.findAll())).thenReturn(USER_LIST);
        List<UserRest> response = userService.getUsers();
        assertThat(response.get(0).getName()).isSameAs(USER_1.getName());
        Mockito.verify(userRepository).findAll();
    }

}
