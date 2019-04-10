package com.neuedu.dao;

import com.neuedu.entity.User;
import com.neuedu.entity.User02;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDAO03 {

    List<User02> selectAll();

    User02 selectById(@Param("id") Integer id);  //Param里的id跟后边Integer定义的id没有任何关系

    Integer insertUser(@Param("user") User02 user);  //插入传的是一个对象了



}
