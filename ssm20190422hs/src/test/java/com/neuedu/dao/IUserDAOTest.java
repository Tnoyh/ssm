package com.neuedu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//  1 ：使用Spring进行测试，运行的时候使用SpringRunner进行运行
//  2 ：告诉它我们这个文件在哪儿啊，在Spring-dao.xml里
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:Spring-dao.xml")
public class IUserDAOTest {

    // 3 ：然后在这里面在进行测试，首先我们要导入userDAO这个对象
    // 4 ：使用注解的形式给他进行自动装配Autowired
    @Autowired
    private IUserDAO userDAO;

    // 5：完成之后给它进行输出
    @Test
    public void selectAll() {
        System.out.println(userDAO.selectAll());
    }
}