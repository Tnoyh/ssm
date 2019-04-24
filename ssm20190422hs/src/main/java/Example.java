public class Example {
    /*

    ssm整合
    * 1: 创建maven的时候要导入两个东西
    *    a):spring
    *    b):web
    * 2：引入jar包
    *    1）spring核心
    *    2）spring-webmvc
    *        servlet-api（因为Springmvc的底层是servlet）
    *    3）跟数据库有关的
    *       a:mysql
    *       b:mybatis
    *       c:数据库连接池
    *       d：spring-jdbc
    *       c：spring-tx：事务声明，声明事务的，事务管理
    *       d：mybatis-spring整合
    *    4）其他（包括分页其他乱七八糟的东西）
    *       a:日志
    *       b:测试
    *          单元测试
    *          spring-test（现在都用Spring跟单元测试合一块儿）
    *       c:分页
    *       d：jstl（不使用Java语言来进行接收）
    *
    *  3:相关的java文件和jsp页面等等，导入
    *
    *  4:配置
    *     1）spring-dao 数据库配置 （配置需要一定的约束，创建Spring-dao.xml）
    *        配置数据源
    *        配置SqlSessionFactory
    *        自动完成(通过Spring给他进行完成的)：SqlSession生成的对象--接口的对象
    *        测试
    *      2)spring-service配置
    *         就是扫描注解，并识别注解
    *         事务声明
    *         测试
    *      3)第三步：配两文件(在web.xml里面进行配置)
    *        web.xml spring-web
    *          a:web.xml
    *             dispatcherServlet
    *             字符编码
    *          b:spring-web
    *             扫描注解（扫描的是谁了？patcher里面的东西）
    *             视图解析器
    *
    *
    *其他的
    * 1：分页
    *    1）对Controller进行配置
    *       进行什么配置？接收网页的信息：a:当前的页数（第几页的数据）
    *                                b:每页的数量（每页有多少条记录）
    *    2）页面设置
    *        1）添加按钮
    *        2）实现
    *
    * 2:json
    *   1)jar引入
    *   2）商品添加时候中有类型
    *      ajax调用
    *       a:controller中的实现
    *           Filter接口  实现 doFilter（）中写字符编码--request response
    *
    *
    *
    *
    *   ******************************************************************************************
    *
    *   4月23内容⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️
    *
    *     3）用户名的唯一性
    *         1:用户名唯一性
                 1）useradd.jsp


     2：图片处理
        1）引入jar
        2）配置goodsadd.jsp页面
        3) 配置 spring-web.xml
        4) 传入的对象和数据库处理对象不一样了
           定义一个vo ：存放一些web，业务处理的对象
        5) Controller
           图片接收：MultipartFile类进行接收
        6）数据中保存的是图片名String
           a:图片名自定义
           b:保存图片（服务器保存，本地保存（第三方））

    *
    *
    *
    * */
}
