package com.lee.beetl.controller;

import com.lee.beetl.pojo.User;
import com.lee.beetl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author : lee Cather <br>
 * date : 2018-11-02 15:21 <br>
 * desc :  <br>
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/findAll")
    public List<User> findAll()
    {
        return userService.findAll();
    }
    @PostMapping("/add")
    public int add(@ModelAttribute User user){
        return userService.add(user);
    }
}
