package com.spring.mvc.service;

import com.spring.mvc.entity.User;

import java.util.List;

/**
 * Mostly used as a facade so all controllers have a single point of entry.
 */
public interface UserService {

    User save(User user);

    void delete(User user);

    User getById(Long userId);

    User update(User user);

    List<User> getAll();

    User findByLastName(String lastName);
}
