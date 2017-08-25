package org.spring.boot.data.jpa.mysql.example.controllers;

import org.spring.boot.data.jpa.mysql.example.domain.User;
import org.spring.boot.data.jpa.mysql.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, params = "add")
    public ModelAndView addUser(HttpServletRequest request) {
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String email = request.getParameter("email");
        if (userService.getByEmail(email) == null)
            userService.add(new User(first, last, email));

        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, params = "delete")
    public ModelAndView deleteUser(HttpServletRequest request) {
        String requestId = request.getParameter("delete");
        Long id = !requestId.equals("") ? Long.parseLong(request.getParameter("delete")) : -1;
        if (id != -1)
            if (userService.getOne(id) != null)
                userService.delete(id);

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
