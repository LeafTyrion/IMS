package com.nefu.IMS.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Calendar getNow = Calendar.getInstance();

//  获取当前日期时间并返回
    public String getNowDate() {
        return simpleDateFormat.format(new Date());
    }

//  计算出还书时间并返回
    public String getReDate(String getNowDate){
        try {
            Date date = simpleDateFormat.parse(getNowDate);
            getNow.setTime(date);
            getNow.add(Calendar.MONTH, 2);
            return simpleDateFormat.format(getNow.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return "日期格式错误";
        }
    }

//  日期比较判断是否逾期
    public boolean compareDate(String reDate,String vaReDate){
        //若逾期返回true
        return vaReDate.compareTo(reDate) > 0;
    }

}
