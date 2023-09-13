package com.qeecan.mycalendar.bean;

import java.io.Serializable;

public class ConsBean implements Serializable {
    private String consname;
    private int consimgResId;

    public ConsBean() {
    }

    public ConsBean(String consname, int consimgResId) {
        this.consname = consname;
        this.consimgResId = consimgResId;
    }

    public String getConsname() {
        return consname;
    }

    public int getConsimgResId() {
        return consimgResId;
    }

    public void setConsname(String consname) {
        this.consname = consname;
    }

    public void setConsimgResId(int consimgResId) {
        this.consimgResId = consimgResId;
    }
}
