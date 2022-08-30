package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userDaoImp;

    @Autowired
    public UserController(UserService userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @GetMapping("/user")
    public String getUserList(Model model) {
        model.addAttribute("user", userDaoImp.getUserList());
        model.addAttribute("newuser", new User());
        return "user";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "save";
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute("user") User user) {
        userDaoImp.saveUser(user);
        return "redirect: /user";
    }


    @GetMapping("/user/edit/{id}")
    public String updateUser(@PathVariable("id") Long userId, Model model) {
        model.addAttribute("user", userDaoImp.showUser(userId));
        return "edit";
    }

    @PatchMapping("/user/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userDaoImp.updateUser(id, user);
        return "redirect: /user";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long userId) {
        userDaoImp.deleteUser(userId);
        return "redirect: /user";
    }
}
