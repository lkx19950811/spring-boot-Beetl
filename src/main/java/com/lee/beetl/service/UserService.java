package com.lee.beetl.service;

import com.lee.beetl.dao.UserRepository;
import com.lee.beetl.pojo.User;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : lee Cather <br>
 * date : 2018-11-02 15:19 <br>
 * desc :  <br>
 */
@Service
public class UserService {
    @Autowired
    private SQLManager sqlManager;
    @Autowired
    UserRepository userMapper;

    public int add(User user){
        return sqlManager.insert(user,true);
    }
    public List<User> findAll(){
        return sqlManager.all(User.class);
    }
    public List<User> selectUsers(User user){
        return userMapper.selectUsers(user);
    }
}
