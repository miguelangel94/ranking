package com.challenge.ranking.controllers.impl;

import com.challenge.ranking.controllers.UserController;
import com.challenge.ranking.entites.User;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.UserRest;
import com.challenge.ranking.responses.RankingResponse;
import com.challenge.ranking.services.UserService;
import com.challenge.ranking.utils.constants.CommonConstants;
import com.challenge.ranking.utils.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_USER)
public class UserControllerImpl  implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RankingResponse<List<UserRest>> getUsers() throws RankingException {
        return new RankingResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                userService.getUsers());
    }
}
