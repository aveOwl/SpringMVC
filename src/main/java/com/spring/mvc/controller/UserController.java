package com.spring.mvc.controller;

import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;
import com.spring.mvc.validator.UserFormValidator;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    @Qualifier("userFormValidator")
    private UserFormValidator userFormValidator;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        log.trace("binding validator ...");
        binder.setValidator(userFormValidator);
    }

    @ModelAttribute("userForm")
    public User createUserModel() {
        return new User();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        log.trace("showAllUsers");
        List<User> users = userService.getAll();
        if (users == null) {
            log.trace("no users found");
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "No Users Found");
        }
        log.debug("user's list: {}", users);
        model.addAttribute("users", users);
        return "user/showUsers";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {
        log.trace("showAddUserForm");
        User user = new User();
        model.addAttribute("userForm", user);
        return "user/SaveUpdateUser";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user, BindingResult result,
                                   Model model, final RedirectAttributes redirectAttributes) {

        log.debug("saveOrUpdateUser() : {}", user);

        if (result.hasErrors()) {
            log.trace("returning form page");
            return "user/SaveUpdateUser";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (user.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }
            userService.save(user);
            log.trace("saving user: {}", user);
            model.addAttribute("user", user);

            return "redirect:/user/" + user.getUserId();
        }
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String showUserById(@PathVariable Long userId, Model model) {
        log.trace("showUserById");
        User user = userService.getById(userId);
        if (user == null) {
            log.trace("user not found");
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User Not Found");
        }
        log.debug("with id: {} found user: {}", userId, user);
        model.addAttribute("user", user);
        return "user/profile";
    }

    @RequestMapping(value = "/user/{userId}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable Long userId, Model model) {
        log.trace("updating user with id: {}", userId);

        User user = userService.getById(userId);
        model.addAttribute("userForm", user);

        return "user/SaveUpdateUser";
    }

    @RequestMapping(value = "/users/{userId}/delete", method = RequestMethod.POST)
    public String deleteUser(@PathVariable Long userId, final RedirectAttributes redirectAttributes) {
        log.debug("removing user with id: {}", userId);

        userService.delete(userService.getById(userId));

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/users";
    }
}
