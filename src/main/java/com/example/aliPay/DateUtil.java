package com.example.aliPay;/**
 * ${tag}
 *
 * @author zhanghongjian
 * @Date 2019/6/26 13:25
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author：张鸿建
 * @time：2019/6/26
 * @desc：工具类 可以通过时间获取订单编号
 **/
public class DateUtil {
    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String dtLong = "yyyyMMddHHmmss";

    /**
     * 完整时间 yyyy-MM-dd HH:mm:ss
     */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日(无下划线) yyyyMMdd
     */
    public static final String dtShort = "yyyyMMdd";
    
    
    /**
      * @author：张鸿建
      * @date: 2019/6/26
      * @desc: 返回 yyyyMMddHHmmss 类型当前时间
      **/
    public static String getOrderNum() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }
    /**
      * @author：张鸿建
      * @date: 2019/6/26
      * @desc:  返回 yyyy-MM-dd HH:mm:ss 类型当前时间
      **/
    public  static String getDateFormatter(){
        Date date=new Date();
        DateFormat df=new SimpleDateFormat(simple);
        return df.format(date);
    }
    /**
      * @author：张鸿建
      * @date: 2019/6/26
      * @desc:  返回 yyyyMMdd 类型当前时间
      **/
    public static String getDate(){
        Date date=new Date();
        DateFormat df=new SimpleDateFormat(dtShort);
        return df.format(date);
    }

    /**
      * @author：张鸿建
      * @date: 2019/6/26
      * @desc: 产生随机三位数
      **/
    public static String getThree(){
        Random rad=new Random();
        return rad.nextInt(1000)+"";
    }

}
