package com.example.exeption.service;

import com.example.exeption.exeption.InvalidCredentials;
import com.example.exeption.exeption.UnauthorizedUser;
import com.example.exeption.permission.Authorities;
import com.example.exeption.repository.UserRepository;

import java.util.List;

public class AuthorizationService {
    private final UserRepository userRepository = new UserRepository();

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
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