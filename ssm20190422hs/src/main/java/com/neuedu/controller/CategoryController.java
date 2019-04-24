package com.neuedu.controller;

import com.neuedu.entity.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("cate")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    /* @RequestMapping("list")
    public void list(HttpServletResponse response) throws IOException {
        List<Category> listc=categoryService.getAll();

        *//*将list对象转换为json对象*//*
        //一般现在不用这种写法
        ObjectMapper objectMapper=new ObjectMapper();
        String strjson= objectMapper.writeValueAsString(listc);
        System.out.println(strjson);
         //设置编码形式
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //给他返回
        response.getWriter().write(strjson);
    }*/


    /*@RequestMapping("list")
    public void list(PrintWriter printWriter) throws IOException {
        List<Category> listc=categoryService.getAll();

        *//*将list对象转换为json对象*//*
        ObjectMapper objectMapper=new ObjectMapper();
        String strjson= objectMapper.writeValueAsString(listc);
        System.out.println(strjson);
        printWriter.write(strjson);
    }*/

    /*
    * spring : @ResponseBody
    *     @ResponseBody
    该注解用于将Controller的方法返回的对象，
    通过适当的HttpMessageConverter转换为指定格式后，
    写入到Response对象的body数据区。
       （推荐使用此方法）
    * */
    @RequestMapping("list")
    @ResponseBody
    public List<Category> list() throws IOException {
        List<Category> listc=categoryService.getAll();
        return listc;

    }


}
