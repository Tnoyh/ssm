package com.neuedu.dao;

import com.neuedu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDAO {

    List<User> selectAll();

    User selectById(@Param("id") Integer id);  //Param里的id跟后边Integer定义的id没有任何关系

    Integer insertUser(@Param("user") User user);  //插入传的是一个对象了



}
