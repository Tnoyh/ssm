package com.neuedu.aspect;

public class InsertBook {

    //插入的通知，有两个，一个创建 一个失效 实现太快 用毫秒来显示
    public  void  create(){
        System.out.println("创建时间："+System.currentTimeMillis());
    }

    public void destroy(){
        System.out.println("失效时间："+System.currentTimeMillis());
    }
}
