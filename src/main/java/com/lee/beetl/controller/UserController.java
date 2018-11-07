package com.lee.beetl.controller;

import com.lee.beetl.pojo.User;
import com.lee.beetl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : lee Cather <br>
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
    @PostMapping("/select")
    public List<User> select (@ModelAttribute User user){
        return userService.selectUsers(user);
    }
    @PostMapping("/query")
    public List<User> query (@RequestParam(required = false) Integer age,@RequestParam(required = false) String name){
        return userService.queryNewUser(age,name);
    }
}
