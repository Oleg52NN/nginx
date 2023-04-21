package com.example.exeption.user;

import com.example.exeption.permission.Authorities;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.util.List;
import java.util.Objects;

public class User {
    private final List<Authorities> permission = List.of(Authorities.values());
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
    @NotBlank
    @Size(min = 2, max = 20)
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getPermission() {
        return permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && permission == user.permission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, permission);
    }
}
