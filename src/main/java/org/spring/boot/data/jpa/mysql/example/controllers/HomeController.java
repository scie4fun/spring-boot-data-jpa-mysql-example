package org.spring.boot.data.jpa.mysql.example.controllers;

import org.spring.boot.data.jpa.mysql.example.domain.User;
import org.spring.boot.data.jpa.mysql.example.repository.UserRepository;
import org.spring.boot.data.jpa.mysql.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/users";
    }

    @RequestMapping("/users")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = {"/{id}", "/users/{id}"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView homeId(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", userService.getOne(id));
        return modelAndView;
    }
}
