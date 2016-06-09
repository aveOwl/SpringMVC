package com.spring.mvc.service.impl;

import com.spring.mvc.entity.User;
import com.spring.mvc.repository.UserRepository;
import com.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findOne(userId);
    }

    /*@Override
    public User getByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }*/

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
