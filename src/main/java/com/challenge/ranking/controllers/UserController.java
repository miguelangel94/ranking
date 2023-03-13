package com.challenge.ranking.controllers;

import com.challenge.ranking.entites.User;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.UserRest;
import com.challenge.ranking.responses.RankingResponse;

import java.util.List;

public interface UserController {

    RankingResponse<List<UserRest>> getUsers() throws RankingException;
}
