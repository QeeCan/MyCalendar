package com.qeecan.mycalendar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.qeecan.mycalendar.R;

import com.qeecan.mycalendar.adapter.WeaRecyclerAdapter;
import com.qeecan.mycalendar.networkapi.WebApiService;

import com.qeecan.mycalendar.typebean.TypeBean;
import com.qeecan.mycalendar.weanetbean.WeaBaseResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String key = "4a5d72bc61c468061dec4dd1bffc89a3";
    String[] cityname = {
            "昆明", " 玉溪", " 大理", "曲靖", "昭通", "保山", "丽江",
            "临沧", "楚雄", "开远", "个旧", "景洪", "安宁", "宣威"};


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private WeaRecyclerAdapter weaRecyclerAdapter;
    private List<TypeBean> typeBeanList;
    private Retrofit retrofit;
    private Toolbar toolbar;

    public WeatherFragment() {
        // Required empty public constructor
    }


    public static WeatherFragment newInstance(String param1, String param2) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rcy_wea);
        toolbar = view.findViewById(R.id.tb_weather);
        typeBeanList = new ArrayList<>();
        retrofitpostmsg();
        weaRecyclerAdapter = new WeaRecyclerAdapter(view.getContext(), typeBeanList);
        recyclerView.setAdapter(weaRecyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    private String getCityName(){
        Random random = new Random();
        int ran = random.nextInt(14);
        String city = cityname[ran];
        Log.i("leacity",city);
        return city;
    }

    private void retrofitpostmsg() {
        String city = getCityName();
        retrofit = new Retrofit.Builder().baseUrl("http://apis.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebApiService webApiService = retrofit.create(WebApiService.class);
        Call<WeaBaseResponse> call = webApiService.getwWeaInfo(city, key);
        call.enqueue(new Callback<WeaBaseResponse>() {
            @Override
            public void onResponse(Call<WeaBaseResponse> call, Response<WeaBaseResponse> response) {
                if (response.body() != null) {
                    String result = response.body().toString();
                    Log.i("lealuck", result);
                    //使用LuckBean对象拿到body()
                    WeaBaseResponse weaBaseResponse = response.body();
                    //将得到的data按照RcylLuckBean的形式注入
                       initData(weaBaseResponse);
                    //设置适配器
                    recyclerView.setAdapter(weaRecyclerAdapter);

                } else {
                    //失败抛出异常，用toast提醒用户是网络连接的问题
                    Toast.makeText(getContext(), "Network Connection Error!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<WeaBaseResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Network Connection Error!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initData(WeaBaseResponse weaBaseResponse) {
        TypeBean city =new TypeBean("城市 ",weaBaseResponse.getResult().getCity());
        TypeBean info = new TypeBean("天气情况", weaBaseResponse.getResult().getRealtime().getInfo());
        TypeBean temperture = new TypeBean("温度", weaBaseResponse.getResult().getRealtime().getTemperature());
        TypeBean humidity = new TypeBean("湿度", weaBaseResponse.getResult().getRealtime().getHumidity());
        TypeBean wid = new TypeBean("风级", weaBaseResponse.getResult().getRealtime().getWid());
        TypeBean direct = new TypeBean("风向", weaBaseResponse.getResult().getRealtime().getDirect());
        TypeBean power = new TypeBean("风力", weaBaseResponse.getResult().getRealtime().getPower());
        TypeBean aqi = new TypeBean("空气质量指数", weaBaseResponse.getResult().getRealtime().getAqi());

        typeBeanList.add(city);
        typeBeanList.add(info);
        typeBeanList.add(temperture);
        typeBeanList.add(humidity);
        typeBeanList.add(wid);
        typeBeanList.add(direct);
        typeBeanList.add(power);
        typeBeanList.add(aqi);





    }
}