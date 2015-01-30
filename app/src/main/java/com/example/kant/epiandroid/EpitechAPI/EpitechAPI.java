package com.example.kant.epiandroid.EpitechAPI;

import java.util.List;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Quentin on 20/01/2015.
 */

public interface EpitechAPI {

    @FormUrlEncoded
    @POST(Constants.LOGIN_URL)
    public void loginPost(@Field(Constants.LOGIN) String login,
                          @Field(Constants.PASSWORD) String password,
                          Callback<Login> callback);

    @GET(Constants.INFOS_URL)
    public void infosGet(@Query(Constants.TOKEN) String token,
                         Callback<HomeInfos> callback);

    @GET(Constants.PLANNING_URL)
    public void planningGet(@Query(Constants.TOKEN) String token,
                            @Query(Constants.START) String start,
                            @Query(Constants.END) String end,
                            Callback<Planning> callback);

    @GET(Constants.SUSIES_URL)
    public void susiesGet(@Query(Constants.TOKEN) String token,
                          @Query(Constants.START) String start,
                          @Query(Constants.END) String end,
                          @Query(Constants.GET) String get,
                          Callback<List<Susie>> callback);

    @GET(Constants.SUSIE_URL)
    public void susieGet(@Query(Constants.TOKEN) String token,
                         @Query(Constants.ID) String id,
                         Callback<Susie> callback);

    @FormUrlEncoded()
    @POST(Constants.SUSIE_URL)
    public void susieSub(@Field(Constants.TOKEN) String token,
                         @Field(Constants.ID) String id,
                         Callback<String> callback);

    @FormUrlEncoded()
    @DELETE(Constants.SUSIE_URL)
    public void susieUnsub(@Field(Constants.TOKEN) String token,
                           @Field(Constants.ID) String id,
                           Callback<String> callback);

    @GET(Constants.PROJECTS_URL)
    public void projectsGet(@Query(Constants.TOKEN) String token,
                            Callback<List<Project>> callback);

    @GET(Constants.PROJECT_URL)
    public void projectGet(@Query(Constants.TOKEN) String token,
                           @Query(Constants.SCOLARYEAR) String scolaryear,
                           @Query(Constants.CODEMODULE) String codemodule,
                           @Query(Constants.CODEINSTANCE) String codeinstance,
                           @Query(Constants.CODEACTI) String codeacti,
                           Callback<Project> callback);

    @FormUrlEncoded
    @POST(Constants.PROJECT_URL)
    public void projectSub(@Field(Constants.TOKEN) String token,
                           @Field(Constants.SCOLARYEAR) String scolaryear,
                           @Field(Constants.CODEMODULE) String codemodule,
                           @Field(Constants.CODEINSTANCE) String codeinstance,
                           @Field(Constants.CODEACTI) String codeacti,
                           Callback<ProjectGroup> callback);

    @FormUrlEncoded
    @DELETE(Constants.PROJECT_URL)
    public void projectUnsub(@Field(Constants.TOKEN) String token,
                             @Field(Constants.SCOLARYEAR) String scolaryear,
                             @Field(Constants.CODEMODULE) String codemodule,
                             @Field(Constants.CODEINSTANCE) String codeinstance,
                             @Field(Constants.CODEACTI) String codeacti,
                             Callback<String> callback);

    @GET(Constants.PROJECT_FILES_URL)
    public void projectFilesGet(@Query(Constants.TOKEN) String token,
                                @Query(Constants.SCOLARYEAR) String scolaryear,
                                @Query(Constants.CODEMODULE) String codemodule,
                                @Query(Constants.CODEINSTANCE) String codeinstance,
                                @Query(Constants.CODEACTI) String codeacti,
                                Callback<ProjectFiles> callback);

    @GET(Constants.MODULES_URL)
    public void modulesGet(@Query(Constants.TOKEN) String token,
                           Callback<Modules> callback);

    @GET(Constants.ALLMODULES_URL)
    public void allModulesGet(@Query(Constants.TOKEN) String token,
                              @Query(Constants.SCOLARYEAR) String scolaryear,
                              @Query(Constants.LOCATION) String location,
                              @Query(Constants.COURSE) String course,
                              Callback<AllModules> callback);

    @GET(Constants.MODULE_URL)
    public void moduleGet(@Query(Constants.TOKEN) String token,
                          @Query(Constants.SCOLARYEAR) String scolaryear,
                          @Query(Constants.CODEMODULE) String codemodule,
                          @Query(Constants.CODEINSTANCE) String codeinstance,
                          Callback<ModuleInfo> callback);

    @FormUrlEncoded
    @POST(Constants.MODULE_URL)
    public void moduleSub(@Field(Constants.TOKEN) String token,
                          @Field(Constants.SCOLARYEAR) String scolaryear,
                          @Field(Constants.CODEMODULE) String codemodule,
                          @Field(Constants.CODEINSTANCE) String codeinstance,
                          Callback<String> callback);

    @FormUrlEncoded
    @DELETE(Constants.MODULE_URL)
    public void moduleUnsub(@Field(Constants.TOKEN) String token,
                            @Field(Constants.SCOLARYEAR) String scolaryear,
                            @Field(Constants.CODEMODULE) String codemodule,
                            @Field(Constants.CODEINSTANCE) String codeinstance,
                            Callback<String> callback);

    @GET(Constants.EVENT_URL)
    public void eventGet(@Query(Constants.TOKEN) String token,
                         @Query(Constants.SCOLARYEAR) String scolaryear,
                         @Query(Constants.CODEMODULE) String codemodule,
                         @Query(Constants.CODEINSTANCE) String codeinstance,
                         @Query(Constants.CODEEVENT) String codeevent,
                         Callback<Event> callback);

    @FormUrlEncoded
    @POST(Constants.EVENT_URL)
    public void eventSub(@Field(Constants.TOKEN) String token,
                         @Field(Constants.SCOLARYEAR) String scolaryear,
                         @Field(Constants.CODEMODULE) String codemodule,
                         @Field(Constants.CODEINSTANCE) String codeinstance,
                         @Field(Constants.CODEEVENT) String codeevent,
                         Callback<String> callback);

    @FormUrlEncoded
    @DELETE(Constants.EVENT_URL)
    public void eventUnsub(@Field(Constants.TOKEN) String token,
                           @Field(Constants.SCOLARYEAR) String scolaryear,
                           @Field(Constants.CODEMODULE) String codemodule,
                           @Field(Constants.CODEINSTANCE) String codeinstance,
                           @Field(Constants.CODEEVENT) String codeevent,
                           Callback<String> callback);

    @GET(Constants.MARKS_URL)
    public void marksGet(@Query(Constants.TOKEN) String token,
                         Callback<Marks> callback);

    @GET(Constants.MESSAGES_URL)
    public void messagesGet(@Query(Constants.TOKEN) String token,
                            Callback<List<Message>> callback);


    @GET(Constants.ALERTS_URL)
    public void alertsGet(@Query(Constants.TOKEN) String token,
                          Callback<List<Alert>> callback);

    @GET(Constants.PHOTO_URL)
    public void photoGet(@Query(Constants.TOKEN) String token,
                         @Query(Constants.LOGIN) String login,
                         Callback<Photo> callback);

    @FormUrlEncoded
    @POST(Constants.TOKEN_URL)
    public void tokenValidation(@Field(Constants.TOKEN) String token,
                                @Field(Constants.SCOLARYEAR) String scolaryear,
                                @Field(Constants.CODEMODULE) String codemodule,
                                @Field(Constants.CODEINSTANCE) String codeinstance,
                                @Field(Constants.CODEACTI) String codeacti,
                                @Field(Constants.TOKENVALIDATIONCODE) String tokenvalidationcode,
                                Callback<String> callback);

    @GET(Constants.TROMBI_URL)
    public void trombiGet(@Query(Constants.TOKEN) String token,
                          @Query(Constants.YEAR) String year,
                          @Query(Constants.LOCATION) String location,
                          @Query(Constants.COURSE) String course,
                          @Query(Constants.PROMO) String promo,
                          @Query(Constants.OFFSET) int offset,
                          Callback<Trombi> callback);

    @GET(Constants.USER_URL)
    public void userGet(@Query(Constants.TOKEN) String token,
                        @Query(Constants.USER) String login,
                        Callback<Infos> callback);

}
