package com.neuedu.dao;

import com.neuedu.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDAO {

    /**
     * 使用注解的实现
     * @select
     */
    @Select("select uid,uname,upwd,telephont,address,ulevel from t_user")
    List<User> selectall();
}
