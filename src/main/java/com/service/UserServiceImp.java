package com.service;

import com.dao.UserDaoImp;
import com.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDaoImp userDaoImp;


    public UserServiceImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return userDaoImp.getUserList();
    }

    @Override
    @Transactional(readOnly = true)
    public User showUser(Long id) {
        return userDaoImp.showUser(id);
    }

    @Override
    public void saveUser(User user) {
        userDaoImp.saveUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userDaoImp.deleteUser(userId);
    }


    @Override
    public void updateUser(Long id, User user) {
        userDaoImp.updateUser(id, user);
    }

}
