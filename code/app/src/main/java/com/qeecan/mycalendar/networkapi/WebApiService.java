package com.qeecan.mycalendar.networkapi;

import com.qeecan.mycalendar.oldnetbean.OldBaseResponse;
import com.qeecan.mycalendar.bean.LuckBean;
import com.qeecan.mycalendar.oldnetbean.Result;
import com.qeecan.mycalendar.weanetbean.WeaBaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebApiService {
    @GET("/constellation/getAll")
    Call<LuckBean> getLuckInfo(@Query("consName") String consname, @Query("type") String type, @Query("key") String key);

    @GET("/simpleWeather/query")
    Call<WeaBaseResponse> getwWeaInfo(@Query("city") String city, @Query("key")String key);

    @POST("/laohuangli/d")
    @FormUrlEncoded
    Call<OldBaseResponse> getOldInfo(@Field("date") String date, @Field("key") String key);


    @GET("/laohuangli/d")
    Call<Result> getOldsInfo(@Query("date") String date, @Query("key") String key);
}
