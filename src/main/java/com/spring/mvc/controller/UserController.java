package com.spring.mvc.controller;

import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        User user = userService.getById(1L);
        model.put("user", user);
        return "user";
    }
}
