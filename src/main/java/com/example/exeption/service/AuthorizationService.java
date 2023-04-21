package com.example.exeption.service;

import com.example.exeption.exeption.InvalidCredentials;
import com.example.exeption.exeption.UnauthorizedUser;
import com.example.exeption.permission.Authorities;
import com.example.exeption.repository.UserRepository;
import com.example.exeption.user.User;

import java.util.List;

public class AuthorizationService {
    private final UserRepository userRepository = new UserRepository();

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}