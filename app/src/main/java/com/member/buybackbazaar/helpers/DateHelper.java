package com.member.buybackbazaar.helpers;

import android.annotation.SuppressLint;
import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private Context context;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public DateHelper(Context context) {
        this.context = context;
    }

    public String getTodayDate(){
        Date c = Calendar.getInstance().getTime();
        return dateFormat.format(c);
    }
    public String getTomorrowDate(){
        Calendar calendar=Calendar.getInstance();
        Date date=new Date();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        Date c = calendar.getTime();
        return dateFormat.format(c);
    }

    public String dateFormatConverter(String date,String format){

        Date dateObj = null;
        try {
            dateObj = dateFormat.parse(date);
            @SuppressLint("SimpleDateFormat") SimpleDateFormat postFormat = new SimpleDateFormat(format);

            return postFormat.format(dateObj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return "";
    }
    public Date stringToDateConversion(String date){
        try {
           return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

