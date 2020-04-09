package com.member.buybackbazaar.retrofit;


import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

//    @POST("api/add_wishlish")
//    Call<GeneralResponseModel> addSavedItemRequest(@Body Map<String, String> params);
//
//    @POST("api/forgot_password")
//    Call<GeneralResponseModel> forgetPassword(@Body Map<String, String> params);
//
//    @POST("api/apply_filters")
//    Call<CategoryProductsResponseModel> getApplyFilterRequest(@Body ApplyFilterRequestModel applyFilterRequestModel);
//
//    @POST("api/add_cart")
//    Call<CartResponseModel> addToCartRequest(@Body AddToCartRequestModel addToCartRequestModel);
//
//    @POST("api/add_selected_cart")
//    Call<CartResponseModel> addSelectedCartRequest(@Body AddToCartRequestModel addToCartRequestModel);
//
//
//    ////////// delete Methods ///////////
//
//    @DELETE
//    Call<GeneralResponseModel> removeSavedItemRequest(@Url String url);
//
//    @DELETE
//    Call<GeneralResponseModel> removeCartItemRequest(@Url String url);

    ///////////////////////////////////////////////////////////////////////

    @POST
    Call<JsonObject> postApiRequests(@Url String url, @Body JsonObject jsonObject);

    @GET
    Call<JsonObject> getApiRequests(@Url String url);

    @FormUrlEncoded
    @POST
    Call<JsonObject> createTransaction(@Url String url, @Field("nonce") String nonce, @Field("merchant_account_id") String merchantAccountId);



}