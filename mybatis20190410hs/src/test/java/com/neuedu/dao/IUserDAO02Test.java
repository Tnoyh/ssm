package com.neuedu.dao;

import com.neuedu.dao.IUserDAO02;
import com.neuedu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class IUserDAO02Test {

    SqlSessionFactory sqlSessionFactory=null;

    @Before
    public void before() throws IOException {
        /**
         *  1：文件提取
         */
        String resource="mybatis-config.xml";
        /**
         *  2：生成io流 我们生成的就是InputStream输入流
         */
        InputStream inputStream= Resources.getResourceAsStream(resource);
        /**
         *  3：生成SqlSessionFactory对象
         */
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void selectAll(){
        SqlSession session=sqlSessionFactory.openSession();

        IUserDAO02 userDAO02=session.getMapper(IUserDAO02.class);

        System.out.println(userDAO02.selectAll());

        session.close();

    }

    @Test
    public void selectById(){


        SqlSession session=sqlSessionFactory.openSession();

        IUserDAO02 userDAO02=session.getMapper(IUserDAO02.class);

        System.out.println(userDAO02.selectById(2));

        session.close();
    }

    @Test
    public void insertUser(){

        User user=new User();
        user.setUname("chen");
        user.setUpwd("123654");
        user.setUid(12);
        user.setAddress("萧山");
        user.setTelephont("12345678909");
        user.setUlevel(1);

        SqlSession session=sqlSessionFactory.openSession();

        IUserDAO02 userDAO02=session.getMapper(IUserDAO02.class);

        System.out.println("受影响的行数"+ userDAO02.insertUser(user));

        session.commit();
        session.close();

    }

}