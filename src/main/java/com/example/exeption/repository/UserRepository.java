package com.example.exeption.repository;

import com.example.exeption.permission.Authorities;
import com.example.exeption.user.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {
    private final ConcurrentHashMap<String, User> userMap = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        setUser();
        if (userMap.containsKey(password)) {
            if (userMap.get(password).getName().equals(user)) {
                return userMap.get(password).getPermission();
            }
        }
        return null;
    }

    void setUser() {
        User user = new User("tok", "12345");
        userMap.put("12345", user);
        User user1 = new User("kot", "11234");
        userMap.put("11234", user1);
        User user2 = new User("tut", "45");
        userMap.put("45", user2);
        User user3 = new User("sok", "345");
        userMap.put("345", user3);
    }
}
