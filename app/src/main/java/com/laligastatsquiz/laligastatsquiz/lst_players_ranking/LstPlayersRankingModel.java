package com.laligastatsquiz.laligastatsquiz.lst_players_ranking;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayerCall;
import com.laligastatsquiz.laligastatsquiz.tools.wsLaLiga;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LstPlayersRankingModel implements LstPlayersRankingContract.Model {

    private OnLstPlayersRankingListener onLstPlayersRankingListener;
    private String college, leagueID, overallPick, roundNum, roundPick, season, teamID, topX, limit, offset, orderField, orderType;
    private JsonObject jsonObject;
    private ArrayList<LaLigaPlayer> laLigaPlayers;
    private Bundle params;
    private LaLigaPlayerCall laLigaPlayerCall;


    @Override
    public void getPlayersRankingService(OnLstPlayersRankingListener onLstPlayersRankingListener, Bundle params) {

        this.onLstPlayersRankingListener = onLstPlayersRankingListener;
        this.season = season;
        this.leagueID = leagueID;
        this.college = college;
        this.overallPick = overallPick;
        this.roundNum = roundNum;
        this.roundPick = roundPick;
        this.teamID = teamID;
        this.topX = topX;
        this.params = params;

        new PeticionGetLaLigaPlayers().execute();

    }

    public class PeticionGetLaLigaPlayers extends AsyncTask<Void, Void, Boolean> {

        public PeticionGetLaLigaPlayers() {
            super();

        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            jsonObject = new JsonObject();
            laLigaPlayers = new ArrayList<>();


            String statsJson;
            season = "2019";
            String url = "https://apim.laliga.com/public-service/api/v1/subscriptions/laliga-santander-" + season + "/";

            // recogemos del bundle los parametros para el WS


//            leagueID = "00";
//            scope = "S";
//            perMode = bundle.getString("PerMode");
//            statCategory = bundle.getString("StatCategory");
//            season = bundle.getString("Season");
//            seasonType = bundle.getString("SeasonType");
//            activeFlag = "YES";

            limit = "100";
            offset = "0";
            orderField = "stat." + params.getString("StatCategory");
            orderType = "DES";

            //Creando el okhttpclient pasamos los headers necesarios y funciona la peticion
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .addHeader("Ocp-Apim-Subscription-Key", "c13c3a8e2f6b46da9c5c425cf61fab3e")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });


            OkHttpClient client = httpClient.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory
                            .create()).client(client).build();


            wsLaLiga service = retrofit.create(wsLaLiga.class);


            //Call<JsonObject> response = service.getPlayersRanking(college, leagueID, overallPick, roundNum, roundPick, season, teamID, topX);
            Call<JsonObject> response = service.getPlayersRanking(limit, offset, orderField, orderType);
            System.out.println("");
            //            String myRequest = response.request().header("x-nba-stats-origin").toString();
//            String my2 = response.request().header("Referer").toString();
//            String myurl = response.request().url().toString();

            try {

                statsJson = new Gson().toJson(response.execute().body());

                if (statsJson == null) {
                    return false;
                }

                laLigaPlayerCall = new Gson().fromJson(statsJson, LaLigaPlayerCall.class);

                for(LaLigaPlayer laLigaPlayer: laLigaPlayerCall.getPlayer_rankings()){
                    laLigaPlayers.add(laLigaPlayer);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        }

        private String intoString(String textoReal, String textoInsert, int pos) {
            StringBuilder stringBuilder = new StringBuilder(textoReal);
            stringBuilder.insert(pos, textoInsert);
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            try {
                if (resp) {
                    //al componente reactivo le devuelvo la lista de sesiones
                    onLstPlayersRankingListener.onFinished(laLigaPlayers);
                } else {
                    onLstPlayersRankingListener.onFailure("No hay jugadores para esa selección");
                }

            } catch (Exception e) {

                onLstPlayersRankingListener.onFailure("Error: Listar Draft");

            }
        }


    }
}
