package com.lee.beetl.dao;

import com.lee.beetl.pojo.User;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : lee Cather
 * @date : 2018-11-05 15:50
 * desc :
 */
@Service
public interface UserRepository extends BaseMapper<User> {
    /**
     * 使用sqlid中的 selectUsers语句
     * @param user 判断条件实体类
     * @return user合集
     */
    List<User> selectUsers(User user);
}
