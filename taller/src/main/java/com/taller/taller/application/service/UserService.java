package com.taller.taller.application.service;

import java.util.List;

import com.taller.taller.domain.User;

public interface UserService {
    List<User> findAllUsers();
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User findUserById(Long id);
}
