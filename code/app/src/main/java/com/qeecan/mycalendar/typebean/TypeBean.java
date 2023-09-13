package com.qeecan.mycalendar.typebean;

import java.io.Serializable;

public class TypeBean implements Serializable {
    private String type;
    private String content;

    public TypeBean(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public TypeBean() {

    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
