package com.qeecan.mycalendar.typebean;

import java.io.Serializable;

public class RcylvBean implements Serializable {
    private String type;
    private String content;

    public RcylvBean(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public RcylvBean() {

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
