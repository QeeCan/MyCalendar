package com.qeecan.mycalendar.oldnetbean;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {
    /***
     * "result": {
     "id": "1657",
     "yangli": "2014-09-11",
     "yinli": "甲午(马)年八月十八",
     "wuxing": "井泉水 建执位",
     "chongsha": "冲兔(己卯)煞东",
     "baiji": "乙不栽植千株不长 酉不宴客醉坐颠狂",
     "jishen": "官日 六仪 益後 月德合 除神 玉堂 鸣犬",
     "yi": "祭祀 出行 扫舍 馀事勿取",
     "xiongshen": "月建 小时 土府 月刑 厌对 招摇 五离",
     "ji": "诸事不宜"
     }
     */

    private String id;
    private Date yangli;
    private String yinli;
    private String wuxing;
    private String chongsha;
    private String baiji;
    private String jishen;
    private String yi;
    private String xiongshen;
    private String ji;



    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setYangli(Date yangli) {
        this.yangli = yangli;
    }

    public Date getYangli() {
        return yangli;
    }

    public void setYinli(String yinli) {
        this.yinli = yinli;
    }

    public String getYinli() {
        return yinli;
    }

    public void setWuxing(String wuxing) {
        this.wuxing = wuxing;
    }

    public String getWuxing() {
        return wuxing;
    }

    public void setChongsha(String chongsha) {
        this.chongsha = chongsha;
    }

    public String getChongsha() {
        return chongsha;
    }

    public void setBaiji(String baiji) {
        this.baiji = baiji;
    }

    public String getBaiji() {
        return baiji;
    }

    public void setJishen(String jishen) {
        this.jishen = jishen;
    }

    public String getJishen() {
        return jishen;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public String getYi() {
        return yi;
    }

    public void setXiongshen(String xiongshen) {
        this.xiongshen = xiongshen;
    }

    public String getXiongshen() {
        return xiongshen;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }

    public String getJi() {
        return ji;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id='" + id + '\'' +
                ", yangli=" + yangli +
                ", yinli='" + yinli + '\'' +
                ", wuxing='" + wuxing + '\'' +
                ", chongsha='" + chongsha + '\'' +
                ", baiji='" + baiji + '\'' +
                ", jishen='" + jishen + '\'' +
                ", yi='" + yi + '\'' +
                ", xiongshen='" + xiongshen + '\'' +
                ", ji='" + ji + '\'' +
                '}';
    }
}