package com.example.kant.epiandroid.EpitechAPI;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Quentin on 20/01/2015.
 */

public interface EpitechAPI {

    @FormUrlEncoded
    @POST(Constants.LOGIN_URL)
    public void loginPost(@Field(Constants.LOGIN) String login, @Field(Constants.PASSWORD) String password, Callback<Login> callback);

    @FormUrlEncoded
    @POST(Constants.INFOS_URL)
    public void infosPost(@Field(Constants.TOKEN) String token, Callback<HomeInfos> callback);

}
