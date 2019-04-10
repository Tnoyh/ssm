package com.neuedu.dao;

import com.neuedu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDAO02 {

    @Select("select uid,uname,upwd,telephont,address,ulevel from t_user")
    List<User> selectAll();


    @Select("select uid,uname,upwd,telephont,address,ulevel"+
            "from t_user "+
            "where uid=#{id}" )
    User selectById(@Param("id") Integer id);  //Param里的id跟后边Integer定义的id没有任何关系


    @Insert("insert into t_user(uname,upwd,uid,telephont,address,ulevel) " +
            " values (#{uname},#{upwd},#{uid},#{telephont},#{address},#{ulevel}) ")
             //注意！！value里面的字段不能随便写，与user里的要一一对应
    Integer insertUser(User user);  //插入传的是一个对象了
}
