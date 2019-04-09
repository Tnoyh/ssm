package com.neuedu;

public class Example {
    /**
     *
     * 1、maven生命周期：
     * clean：清理，把以前的东西去除掉
     * package：打包 根据打包的类型来确定 jar 、 war等
     * install：生成maven能够使用等jar包
     *       <groupId>www.neuedu.ssm</groupId>
     *
     *     <artifactId>mybatis20190408</artifactId>
     *
     *     version>1.0-SNAPSHOT</
     * compile：编译  对main里的 Java进行编译
     *
     * test：对test中的代码进行编译
     *
     * 2、单元测试
     *    1） jar包进行导入
     *    2） 使用
     *        单元测试一般用在方法上，这个方法：没有返回类型和参数的方法
     *        @Test 注解
     *
     * @before
     *
     * @after
     *
     * Shift + ctrl + T :生成测试类
     *
     * 3、mybatis的简单应用
     *    1）导入jar包（有两个，如下：）
     *        mysql
     *        mybatis
     *
     *
     *    2）配置mybatis-config.xml文件
     *
     *    3）使用的是注解实现select功能
     *
     *    4）进行测试 select功能
     *
     *
     */
}
