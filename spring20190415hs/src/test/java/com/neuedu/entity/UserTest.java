package com.neuedu.entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void usertest(){
        /*  1:创建一个ApplicationContext对象
        *    首先得到容器
        *  */
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        /**
         *   2：容器已经有来 开始创建对象了
         *   User对象的创建:     context.getBean中的值为xml中bean标签的id
         *
         */

        User user=(User)context.getBean("user");

        /**
         * 对象执行里面的say
         */
        user.say();
    }


    /**
     * 使用无参的构造器进行赋值测试
     */
    @Test
    public  void  usersettest(){
        /*  1:创建一个ApplicationContext对象*/
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        /*2：User对象的创建:     context.getBean中的值为xml中bean标签的id值
         */
        User user=(User)context.getBean("user");

        /**
         * 得到对象之后我就进行以下提取
         */
        System.out.println(user.getUid()+"  "+user.getUname()+ "   "+user.getUpwd());;
    }

}
