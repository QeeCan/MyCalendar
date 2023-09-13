package com.qeecan.mycalendar.bean;

public class NewsBean {

    /**
     * "uniquekey": "db61b977d9fabd0429c6d0c671aeb30e",
     * "title": "“新时代女性的自我关爱”主题沙龙暨双山街道福泰社区妇儿活动家园启动仪式举行",
     * "date": "2021-03-08 13:47:00",
     * "category": "头条",
     * "author_name": "鲁网",
     * "url": "https://mini.eastday.com/mobile/210308134708834241845.html",
     * "thumbnail_pic_s": "https://dfzximg02.dftoutiao.com/news/20210308/20210308134708_d0216565f1d6fe1abdfa03efb4f3e23c_0_mwpm_03201609.png",
     * "thumbnail_pic_s02": "https://dfzximg02.dftoutiao.com/news/20210308/20210308134708_d0216565f1d6fe1abdfa03efb4f3e23c_1_mwpm_03201609.png",
     * "thumbnail_pic_s03": "https://dfzximg02.dftoutiao.com/news/20210308/20210308134708_d0216565f1d6fe1abdfa03efb4f3e23c_2_mwpm_03201609.png",
     * "is_content": "1"
     **/

    private String title;
    private String date;
    private String category;
    private String author;
    private String details;
    private String pic;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getDetails() {
        return details;
    }

    public String getPic() {
        return pic;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}
