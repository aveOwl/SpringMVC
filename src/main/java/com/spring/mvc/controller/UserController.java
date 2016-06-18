package com.spring.mvc.controller;

import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;
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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String initCreationForm(ModelMap model) {
        List<User> users = userService.getAll();
        model.put("users", users);
        return "user/users";
    }

    @RequestMapping(value = "/showById/{userId}", method = RequestMethod.GET)
    public String findUser(@PathVariable Long userId, Model model) {
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        return "user/profile";
    }
}
