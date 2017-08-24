package org.spring.boot.data.jpa.mysql.example.services;

import org.spring.boot.data.jpa.mysql.example.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getOne(Long id);

    User getByEmail(String email);

    void add(User user);
}
