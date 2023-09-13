package com.qeecan.mycalendar;

import com.qeecan.mycalendar.oldnetbean.OldBaseResponse;
import com.qeecan.mycalendar.oldnetbean.Result;
import com.qeecan.mycalendar.weanetbean.WeaBaseResponse;
import com.qeecan.mycalendar.networkapi.WebApiService;

import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostTest {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://apis.juhe.cn/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    WebApiService webApiService = retrofit.create(WebApiService.class);

       @Test
   public void getweather() throws IOException {
         Call<WeaBaseResponse>call =webApiService.getwWeaInfo("广州","4a5d72bc61c468061dec4dd1bffc89a3");
         Response<WeaBaseResponse> response = call.execute();
         if (response.body() != null){
             WeaBaseResponse weaBaseResponse=response.body();
             System.out.println(weaBaseResponse);}
     }
    Retrofit retrofit1 = new Retrofit.Builder().baseUrl("http://v.juhe.cn/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    WebApiService webApiService1 = retrofit1.create(WebApiService.class);

    @Test
    public void upup() throws IOException {
        Call<OldBaseResponse> call =webApiService1.getOldInfo("2023-09-13","1fc923ee1e2fbc256bf0f98fe6bacad9");
        Response<OldBaseResponse> response = call.execute();
        OldBaseResponse oldBaseResponse = response.body();
            System.out.println(oldBaseResponse);
    }
    Retrofit retrofit2 = new Retrofit.Builder().baseUrl("http://v.juhe.cn/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    WebApiService webApiService2 = retrofit2.create(WebApiService.class);
    @Test
    public void updown() throws IOException {
        Call<Result> call =webApiService2.getOldsInfo("2023-09-13","1fc923ee1e2fbc256bf0f98fe6bacad9");
        Response<Result> response = call.execute();
        Result result = response.body();
        System.out.println(result);
    }
}
