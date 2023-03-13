package com.challenge.ranking.services.impl;

import com.challenge.ranking.entites.User;
import com.challenge.ranking.exceptions.NotFoundException;
import com.challenge.ranking.exceptions.RankingException;
import com.challenge.ranking.json.UserRest;
import com.challenge.ranking.repositories.UserRepository;
import com.challenge.ranking.services.UserService;
import com.challenge.ranking.utils.constants.ExceptionConstants;
import com.challenge.ranking.utils.converters.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    private UserConverter userConverter = new UserConverter();
    @Override
    public List<UserRest> getUsers() throws RankingException {
        return userRepository.findAll().stream().map(user
                -> userConverter.mapToRest(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserRest findById(Long id) throws RankingException {
        User user;
        user = userRepository.findById(id).orElseThrow(()
                -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));
        return UserConverter.mapToRest(user);
    }
}
