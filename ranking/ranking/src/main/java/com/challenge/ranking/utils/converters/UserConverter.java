package com.challenge.ranking.utils.converters;

import com.challenge.ranking.entites.User;
import com.challenge.ranking.json.UserRest;

public class UserConverter {

    public static UserRest mapToRest(User user) {
        UserRest userRest = new UserRest();
        userRest.setId(user.getId());
        userRest.setName(user.getName());
        return userRest;
    }

    public static User mapToEntity(UserRest userRest) {
        User user = new User();
        user.setId(userRest.getId());
        user.setName(userRest.getName());
        return user;
    }
}
