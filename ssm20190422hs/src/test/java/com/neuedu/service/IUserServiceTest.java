package com.neuedu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//这儿配置文件有两个了，就以数组的形式
@ContextConfiguration({"classpath:Spring-dao.xml","classpath:Spring-service.xml"})
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test  //测试从第一条开始，测试三条记录
    public void getVipAll() {
        System.out.println(userService.getVipAll(1,3));
    }
}