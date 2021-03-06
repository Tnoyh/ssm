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

    @Test
    public  void  usertestbean(){
        /*  1:创建一个ApplicationContext对象*/
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        /*2：User对象的创建:     context.getBean中的值为xml中bean标签的id值
         */
        /*User user=(User)context.getBean("vipuser");*/  //不同的人调用不同的名字 结果还是一样的
        User user=(User)context.getBean("user2 user3 user4"); //以多个名字命名
        System.out.println(user.getUid()+"  "+user.getUname()+ "   "+user.getUpwd());;
    }


    //测试多例模式还是单例模式 输出看他们的地址是否一样
    @Test
    public  void  usertestscope(){
        /*  1:创建一个ApplicationContext对象*/
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        /*2：User对象的创建:     context.getBean中的值为xml中bean标签的id值
         */
        /*User user=(User)context.getBean("vipuser");*/
        User user=(User)context.getBean("user");
        User user2=(User)context.getBean("user");
        System.out.println(user);
        System.out.println(user2);
    }


    @Test
    public  void  usertestautowire(){
        /*  1:创建一个ApplicationContext对象*/
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        /*2：User对象的创建:     context.getBean中的值为xml中bean标签的id值
         */

        User user=(User)context.getBean("user");

        System.out.println(user.getUname());

    }

}
