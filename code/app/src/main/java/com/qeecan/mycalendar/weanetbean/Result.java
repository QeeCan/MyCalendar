package com.qeecan.mycalendar.weanetbean;

import java.util.List;

public class Result {
    private String city;
    private Realtime realtime;
    private List<Future> future;
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }
    public Realtime getRealtime() {
        return realtime;
    }

    public void setFuture(List<Future> future) {
        this.future = future;
    }
    public List<Future> getFuture() {
        return future;
    }

    @Override
    public String toString() {
        return "Result2{" +
                "city='" + city + '\'' +
                ", realtime=" + realtime +
                ", future=" + future +
                '}';
    }
}
