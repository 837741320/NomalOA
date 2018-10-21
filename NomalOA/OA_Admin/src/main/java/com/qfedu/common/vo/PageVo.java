package com.qfedu.common.vo;

import com.qfedu.domain.User;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/8/14 15:02
 * 为LayUI的数据表格准备的数据
 */
public class PageVo<T> {
    private int code;
    private String msg;
    private int count;
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    public static <T> PageVo<T> createPage(List<T> data,int count){
        PageVo<T> pageVo=new PageVo<>();
        pageVo.setCode(0);
        pageVo.setMsg("OK");
        pageVo.setCount(count);
        pageVo.setData(data);
        return pageVo;
    }
}
