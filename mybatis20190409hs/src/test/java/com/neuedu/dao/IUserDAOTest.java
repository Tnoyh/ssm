package com.neuedu.dao;

import com.neuedu.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class IUserDAOTest {

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
    public void selectAll() throws IOException {
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
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);

        /**
         *  4：由工厂生成 SqlSession 对象
         */
        SqlSession session=sqlSessionFactory.openSession();

        /**
         *   5:生成接口对象
         */
        IUserDAO userDAO=session.getMapper(IUserDAO.class);

        /**
         *  6:使用
         */
        List<User> list=userDAO.selectAll();
        System.out.println(list);
        /**
         *  7:关闭
         */
        session.close();
    }

    @Test
    public void selectById(){

        /**
         *  4：由工厂生成 SqlSession 对象
         */
        SqlSession session=sqlSessionFactory.openSession();

        /**
         *   5:生成接口对象
         */
        IUserDAO userDAO=session.getMapper(IUserDAO.class);

        /**
         *  6:使用
         */
        User list=userDAO.selectById(1);
        System.out.println(list);
        /**
         *  7:关闭
         */
        session.close();


    }

    @Test
    public void insertUser(){
        User user=new User();
        user.setUname("huang");
        user.setUpwd("123654");
        user.setUid(11);
        user.setAddress("苏州");
        user.setTelephont("12345678909");
        user.setUlevel(1);


        /**
         *  4：由工厂生成 SqlSession 对象
         *  生成的sqlsession对象 自动提交关闭 默认false
         *   解决方法： 1）sqlSessionFactory.openSession(true);
         *            2）session.commit();
         */
        SqlSession session=sqlSessionFactory.openSession(true); //默认为false 不进行提交

        /**
         *   5:生成接口对象
         */
        IUserDAO userDAO=session.getMapper(IUserDAO.class);

        /**
         *  6:使用
         */
        Integer i=userDAO.insertUser(user);

        //session.commit();
        //在执行完成之后手动进行提交  上边写了true就不写下边  要么进行打开，要么手动进行提交
        // 不提交怎么返回到数据库里面呢。。。。
        System.out.println("受影响的行数为："+i);
        /**
         *  7:关闭
         */
        session.close();

    }

}