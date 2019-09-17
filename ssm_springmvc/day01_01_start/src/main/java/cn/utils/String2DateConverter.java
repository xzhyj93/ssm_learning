package cn.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换日期
 */
public class String2DateConverter implements Converter<String, Date> {
    /**
     * 传入进来字符串
     * @param s
     * @return
     */
    @Override
    public Date convert(String s) {
        if(s == null) {
            throw new RuntimeException("请您传入数据");
        }

        //字符串转日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
           return  df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
