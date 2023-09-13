package com.qeecan.mycalendar.weanetbean;

public class Wid {

    private String day;
    private String night;
    public void setDay(String day) {
         this.day = day;
     }
     public String getDay() {
         return day;
     }

    public void setNight(String night) {
         this.night = night;
     }
     public String getNight() {
         return night;
     }

    @Override
    public String toString() {
        return "Wid{" +
                "day='" + day + '\'' +
                ", night='" + night + '\'' +
                '}';
    }
}