package com.spring.mvc.controller;

import com.spring.mvc.entity.User;
import com.spring.mvc.service.UserService;
import com.spring.mvc.validator.UserFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller manages all incoming requests for user entity.
 */
@Controller
public class UserController {
    /**
     * Logging system.
     */
    private static final Logger LOG =
            LoggerFactory.getLogger(UserController.class);

    /**
     * UserService providing CRUD operations for {@link User} entity.
     */
    private final UserService userService;

    /**
     * {@link UserFormValidator} for validating registration form.
     */
    @Autowired
    @Qualifier("userFormValidator")
    private UserFormValidator userFormValidator;

    /**
     * Initializing userService.
     * @param userService userService to be autowired by Spring.
     */
    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Binding {@code userFormValidator}.
     * @param binder binds web request parametersredirectAttributes
     * to JavaBean objects.
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        LOG.trace("binding validator ...");
        binder.setValidator(userFormValidator);
    }

    /**
     * Binding User entity to model attribute "userForm".
     * @return new user entity.
     */
    @ModelAttribute("userForm")
    public User createUserModel() {
        return new User();
    }

    /**
     * On path "/users" with request method GET mapping all users
     * from database (list of users) to display it in table on web page.
     * @param model holder for model attributes.
     * @return view name.
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        LOG.trace("retrieving users list ...");
        List<User> users = userService.getAll();
        if (users == null) {
            LOG.trace("no users found");
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "No Users Found");
        } else {
            LOG.debug("user's list: {}", users);
            model.addAttribute("users", users);
        }
        return "user/manage-page";
    }

    /**
     * On path "/user/add" mapping user entity.
     * @param model holder for model attributes.
     * @return view name.
     */
    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {
        LOG.trace("creating user entity ...");
        User user = new User();
        model.addAttribute("userForm", user);
        return "user/form-page";
    }

    /**
     * On path "/users" with request method POST mapping user validation.
     * After the redirect, flash attributes are automatically added to the model
     * of the controller that serves the target URL
     * @param user user to be updated/created.
     * @param result allowing error registration,
     * {@link Validator} to be applied.
     * @param model holder for model attributes.
     * @param redirectAttributes used to add flash attributes.
     * @return view name.
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
                                   BindingResult result, Model model,
                                   final RedirectAttributes redirectAttributes) {

        LOG.debug("saving or updating user: {}", user);

        if (result.hasErrors()) {
            LOG.trace("returning form page");
            return "user/form-page";
        }
        redirectAttributes.addFlashAttribute("css", "success");
        if (user.isNew()) {
            redirectAttributes.addFlashAttribute("msg", "User added successfully!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
        }
        userService.save(user);
        LOG.debug("saving user: {}", user);
        model.addAttribute("user", user);

        return "redirect:/user/" + user.getUserId();
    }

    /**
     * On Path "/user/{userId}" mapping single user page.
     * @param userId id of user who's page displayed.
     * @param model holder for model attributes.
     * @return view name.
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String showUserById(@PathVariable Long userId, Model model) {
        LOG.debug("retrieving user with id: {}", userId);
        User user = userService.getById(userId);
        if (user == null) {
            LOG.trace("user not found");
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User Not Found");
        } else {
            LOG.debug("with id: {} found user: {}", userId, user);
            model.addAttribute("user", user);
        }
        return "user/profile-page";
    }

    /**
     * On Path "/user/{userId}/update" mapping user entity update.
     * @param userId id of user to be updated.
     * @param model holder for model attributes.
     * @return view name.
     */
    @RequestMapping(value = "/user/{userId}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable Long userId, Model model) {
        LOG.trace("updating user with id: {}", userId);
        User user = userService.getById(userId);
        model.addAttribute("userForm", user);

        return "user/form-page";
    }

    /**
     * On Path "/user/{userId}/delete" mapping user entity delete.
     * @param userId id of user to be deleted.
     * @param redirectAttributes used to add flash attributes.
     * @return view name.
     */
    @RequestMapping(value = "/user/{userId}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long userId,
                             final RedirectAttributes redirectAttributes) {
        LOG.debug("removing user with id: {}", userId);

        userService.delete(userService.getById(userId));

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/users";
    }

    /**
     * Displays ERROR page when a result was expected to have at least
     * one row (or element) but zero rows (or elements) were actually returned.
     * @param request user request.
     * @param e exception.
     * @return model.
     */
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest request, Exception e) {
        LOG.trace("handling empty data ...");
        LOG.error("request: {}, returned wht error: {}", request.getRequestURL(), e);

        ModelAndView model = new ModelAndView();
        model.setViewName("user/profile-page");
        model.addObject("msg", "user not found");

        return model;
    }
}
