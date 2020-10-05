package com.laligastatsquiz.laligastatsquiz.tools;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface wsLaLiga {


//    @Headers({
//            "Referer: https://stats.nba.com/draft/history/",
//            "Accept: */*",
//            "Accept-Encoding: gzip, deflate, br",
//            "Connection: keep-alive",
//            "Cache-Control: no-cache",
//            "Strict-Transport-Security: max-age=86400",
//            "content-type: application/json; charset=utf-8",
//            "x-nba-stats-origin: stats"
//    })

    @GET("players/rankings")
    Call<JsonObject> getPlayersRanking(
            @Query("limit") String limit,
            @Query("offset") String offset,
            @Query("orderField") String orderField,
            @Query("orderType") String orderType);


    @GET("leagueLeaders")
    Call<JsonObject> getLeagueLeaders(
            @Query("LeagueID") String leagueID,
            @Query("PerMode") String perMode,
            @Query("Scope") String scope,
            @Query("Season") String season,
            @Query("SeasonType") String seasonType,
            @Query("StatCategory") String statCategory,
            @Query("ActiveFlag") String activeFlag);

    @GET("playerprofilev2")
    Call<JsonObject> getCareerHighs(
            @Query("LeagueID") String leagueID,
            @Query("PerMode") String perMode,
            @Query("PlayerID") String playerID);

    @POST("players")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<JsonObject> postJson(@Body JsonObject myBody);





}
