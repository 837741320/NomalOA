package com.qfedu.common.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2018/8/18 10:35
 * 自定义SpringMVC 日期转换器
 */
public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        String pa;
        //yyyy-MM-dd
        //yyyy-MM-dd HH:mm:ss
        if(s.contains(":")){
            pa="yyyy-MM-dd HH:mm:ss";
        }else {
            pa="yyyy-MM-dd";
        }

        SimpleDateFormat sdf=new SimpleDateFormat(pa);
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
