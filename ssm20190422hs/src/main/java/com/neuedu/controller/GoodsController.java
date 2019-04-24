package com.neuedu.controller;

import com.neuedu.service.IGoodsService;
import com.neuedu.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;


    @Autowired
    HttpServletRequest request;

    @GetMapping("goodsadd")
    public String add(){
        return "goodsadd";
    }

    @PostMapping("add")
    //这里面要添加的对象是GoodsVo了
    public String modifyAdd(GoodsVo goodsVo) throws IOException {
       /* System.out.println(goodsVo);//用于测试，可以把对象输出出来*/

        //接下来，对图片进行保存
       /* MultipartFile file=goodsVo.getFile();
          System.out.println(file.getName());*//*标签中name的值*//*
          System.out.println(file.getOriginalFilename());*//*上传过来的文件的名字，原始图片的名字*//*
          System.out.println(file.getInputStream());*//*文件内容，流也就是文件输入流*/
       /*
       *   现在要进行保存
       *  第一步1：需要服务器的路径  HttpServletRequest request;
       * */
        String servicepath=request.getServletContext().getRealPath("/")+"imgload/";

        goodsService.add(goodsVo,servicepath);



        return "redirect:/user/list.do";
    }



}
