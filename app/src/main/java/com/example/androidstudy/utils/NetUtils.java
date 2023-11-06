package com.example.androidstudy.utils;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetUtils {

    private final String TAG = "NetUtils";
    private static NetUtils netUtils;
    private NetUtils(){}

    public static NetUtils getNetUtils() {
        if(netUtils == null) {
            synchronized (NetUtils.class) {
                if(netUtils == null){
                    netUtils = new NetUtils();
                }
            }
        }
        return netUtils;
    }

    public interface ResultCallback{
         void success(String result);
         void failed();
    }

    public void request(String url, ResultCallback callback) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .cookieJar(CookieJar.NO_COOKIES)
                .callTimeout(10000, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .get()
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.failed();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(!response.isSuccessful()) {
                    //请求失败
                }
//                String result = Objects.requireNonNull(response.body()).string();
//                Log.d(TAG, "onResponse " + response.body().string());
//                ResultInfo resultInfo = JsonUtil.parseJson(response.body().string(), ResultInfo.class);
//                Log.d(TAG, "onResponse: ----" + resultInfo.getDataInfo().getTotal());
                callback.success(response.body().string());
            }
        });
    }
}
