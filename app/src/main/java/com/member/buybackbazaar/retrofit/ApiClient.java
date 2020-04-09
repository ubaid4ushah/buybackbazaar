package com.member.buybackbazaar.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String TAG = ApiClient.class.getSimpleName();
    private static Retrofit retrofitApi = null;
    private static Retrofit retrofitGoogle = null;

    public static Retrofit getApiClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request orignalRequest = chain.request();

                Request newRequest = orignalRequest.newBuilder()
                        .header("Content-Type", "application/json")
                       // .header("Authorization", "a76b0cc3-9663-4b2d-b35b-90698c27b122")
                        .build();
                return chain.proceed(newRequest);

            }
        });

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(logging);
        httpClient.readTimeout(30, TimeUnit.SECONDS);

        if (retrofitApi == null) {
            retrofitApi = new Retrofit.Builder()
                    .baseUrl(EndPoints.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofitApi;
    }


//    public static Retrofit getGoogleClient() {
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        httpClient.addInterceptor(logging);
//        httpClient.readTimeout(30, TimeUnit.SECONDS);
//
//        if (retrofitGoogle == null) {
//            retrofitGoogle = new Retrofit.Builder()
//                    .baseUrl(AppConstants.BASEURL_GOOGLE_API)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(httpClient.build())
//                    .build();
//        }
//        return retrofitGoogle;
//    }
}
