package com.spring.mvc.controller;

import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        log.trace("showAllUsers");
        List<User> users = userService.getAll();
        log.debug("user's list: {}", users);
        model.addAttribute("users", users);
        return "user/users";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String showUserById(@PathVariable Long userId, Model model) {
        log.trace("showUserById");
        User user = userService.getById(userId);
        log.debug("with id: {} found user: {}", userId, user);
        model.addAttribute("user", user);
        return "user/profile";
    }
}
