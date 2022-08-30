package com.service;

import com.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    void saveUser(User user);

    void deleteUser(Long userId);

    User showUser(Long id);

    void updateUser(Long id, User user);

}
