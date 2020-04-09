package com.member.buybackbazaar.retrofit;

import android.content.Context;


import com.google.gson.JsonObject;
import com.member.buybackbazaar.R;
import com.member.buybackbazaar.listeners.ResponseListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wahyd on 1/15/2018.
 */

public class ApiRequests {


    private Context context;
    private ResponseListener listener;

    public ApiRequests(Context context, ResponseListener listener) {

        this.context=context;
        this.listener=listener;
    }

    public void postApiRequestMethod(String url, JsonObject params, final String action) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);



        Call<JsonObject> call = apiInterface.postApiRequests(url,params);
        call.enqueue(new Callback<JsonObject>() {
            String message;

            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> resp) {

                if(resp!=null && resp.body()!=null) {
              //      JsonObject json = new JsonParser().parse(resp.body().toString()).getAsJsonObject();

                    if(resp.body().get("status").getAsBoolean()){
                        listener.onSuccess(resp.body(),action);
                    }
                    else {
                        listener.onError(resp.body().get("msg").getAsString());
                    }
                }
                else {
                    listener.onError(resp.message());
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                t.printStackTrace();
                listener.onError(context.getString(R.string.no_internet_connection));
            }
        });
    }

    public void getApiRequestMethod(String url, final String action) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        Call<JsonObject> call = apiInterface.getApiRequests(url);
        call.enqueue(new Callback<JsonObject>() {
            String message;

            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> resp) {



                if(resp!=null && resp.body()!=null){

                    if(action.equalsIgnoreCase("get_token")){
                        listener.onSuccess(resp.body(), action);
                    }else {
                        if (resp.body().get("status").getAsBoolean()) {
                            listener.onSuccess(resp.body(), action);
                        } else {
                            listener.onError(resp.body().get("msg").getAsString());
                        }
                    }
                }
                else {
                    listener.onError(resp.message());
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                t.printStackTrace();
                listener.onError(context.getString(R.string.no_internet_connection));
            }
        });
    }
}
