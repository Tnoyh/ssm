package com.neuedu.service;

import com.neuedu.vo.GoodsVo;

import java.io.IOException;


public interface IGoodsService {
    //这个接口实现的功能就是添加 但是得把goodsvo这个对象以及新文件名传过去
    void add(GoodsVo goodsVo, String newfilename) throws IOException;
}
