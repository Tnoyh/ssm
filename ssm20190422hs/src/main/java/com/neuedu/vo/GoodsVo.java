package com.neuedu.vo;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class GoodsVo {
    private Integer gid;
    private String gnum;
    private String gname;
    private BigDecimal gprice;
    private Integer gstock;
    private Integer gsell;
    private String gdesc;
    private Integer cid;
    private MultipartFile file;//这个文件是在request里面

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGnum() {
        return gnum;
    }

    public void setGnum(String gnum) {
        this.gnum = gnum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public BigDecimal getGprice() {
        return gprice;
    }

    public void setGprice(BigDecimal gprice) {
        this.gprice = gprice;
    }

    public Integer getGstock() {
        return gstock;
    }

    public void setGstock(Integer gstock) {
        this.gstock = gstock;
    }

    public Integer getGsell() {
        return gsell;
    }

    public void setGsell(Integer gsell) {
        this.gsell = gsell;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "GoodsVo{" +
                "gid=" + gid +
                ", gnum='" + gnum + '\'' +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gstock=" + gstock +
                ", gsell=" + gsell +
                ", gdesc='" + gdesc + '\'' +
                ", cid=" + cid +
                ", file=" + file +
                '}';
    }
}
