package com.challenge.ranking.services;

import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.UserRest;

import java.util.List;

public interface UserService {

    List<UserRest> getUsers() throws RankingException;
    UserRest findById(Long id) throws  RankingException;
}
