package com.qeecan.mycalendar.utils;

import android.content.Context;

public class DpnPx {
    public static int Dp2Px(Context context, float dp){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dp*scale+0.5f);
    }
    public static  int Px2Dp(Context context,float px){
        float scale= context.getResources().getDisplayMetrics().density;
        return (int)(px/scale+0.5f);
    }
}
