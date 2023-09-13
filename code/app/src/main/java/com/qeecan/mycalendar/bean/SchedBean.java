package com.qeecan.mycalendar.bean;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SchedBean implements Serializable {
    private long id;
    private String schecontent;
    private Calendar datetime;
    private String schetag;

    public SchedBean(){
        this.datetime=Calendar.getInstance();
    }

    public SchedBean(String schecontent,  String schetag,String time) {
        this.schecontent = schecontent;
        this.schetag = schetag;
        setClock(time);
    }


    public String getSchecontent() {
        return schecontent;
    }

    public String getSchetag() {
        return schetag;
    }

    public void setSchecontent(String schecontent) {
        this.schecontent = schecontent;
    }

    public void setSchetag(String schetag) {
        this.schetag = schetag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDatetime() {
        return datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }


    public int getYear() {
        return datetime.get(Calendar.YEAR);
    }

    public int getMonth() {
        return datetime.get(Calendar.MONTH);
    }

    public int getDay() {
        return datetime.get(Calendar.DAY_OF_MONTH);
    }

    public int getHour() {
        return datetime.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return datetime.get(Calendar.MINUTE);
    }


    public String getClock() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(datetime.getTime());
    }

    public void setClock(String format) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date temp = simpleDateFormat.parse(format);
            Log.d("setClock success", "" + temp);
            datetime = Calendar.getInstance();
            datetime.setTime(temp);
        } catch (ParseException e) {

        }
    }

}
