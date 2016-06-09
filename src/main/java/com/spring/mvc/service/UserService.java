package com.spring.mvc.service;

import com.spring.mvc.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(User user);

    User getById(Long userId);

//    User getByUserName(String userName);

    User update(User user);

    List<User> getAll();
}
