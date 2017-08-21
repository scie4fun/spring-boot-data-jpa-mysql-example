package org.spring.boot.data.jpa.mysql.example.controllers;

import org.spring.boot.data.jpa.mysql.example.domain.User;
import org.spring.boot.data.jpa.mysql.example.repository.UserRepository;
import org.spring.boot.data.jpa.mysql.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<User> home() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User homeId(@PathVariable("id") Long id) {
        return userService.getOne(id);
    }
}
