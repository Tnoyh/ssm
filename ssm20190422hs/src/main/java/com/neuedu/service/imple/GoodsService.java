package com.neuedu.service.imple;

import com.neuedu.dao.IGoodsDAO;
import com.neuedu.entity.Goods;
import com.neuedu.service.IGoodsService;
import com.neuedu.util.ImgUtil;
import com.neuedu.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GoodsService implements IGoodsService {

    @Autowired
    private IGoodsDAO goodsDAO;

    public void add(GoodsVo goodsVo, String servicepath) throws IOException {
        // System.out.println(servicepath);
        /*
         * 2:文件名
         * */
        MultipartFile file=goodsVo.getFile();
        String newFilename=String.valueOf(System.currentTimeMillis())+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        System.out.println(newFilename);

         /*不仅要在服务器上传图片*/
        ImgUtil.onloadImg(servicepath,newFilename,file);

        /*也要在本地上传图片*/
        String localpath="Users\\tnoyh\\Studio\\IDEA\\javaeeDemo\\ssm\\ssm20190422hs\\web\\imgload/";

        ImgUtil.onloadImg(localpath,newFilename,file);

        /*数据添加 数据库里的值跟刚才传的值得一一对应上*/
        Goods goods=new Goods();
        /*类型转换 把goodsVo转换为goods对象 别忘了把新文件的名字转换过来*/
        tranceof(goodsVo,goods,newFilename);

        goodsDAO.insert(goods);
    }

    private void  tranceof(GoodsVo goodsVo, Goods goods, String newfilename){
        goods.setGname(goodsVo.getGname());
        goods.setGprice(goodsVo.getGprice());
        goods.setCid(goodsVo.getCid());
        goods.setGdesc(goodsVo.getGdesc());
        goods.setGstock(goodsVo.getGstock());
        goods.setGsell(goodsVo.getGsell());
        goods.setGnum(goodsVo.getGnum());
        goods.setImgsrc(newfilename);


    }
}
