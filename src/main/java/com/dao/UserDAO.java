package com.dao;

import com.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUserList();

    void saveUser(User user);

    void deleteUser(Long userId);

    void updateUser(Long id, User user);

    User showUser(Long id);
}
