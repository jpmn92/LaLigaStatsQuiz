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
// import com.laligastatsquiz.laligastatsquiz.tools.FooRequest;
import com.laligastatsquiz.laligastatsquiz.data.PlayerCompetition;
import com.laligastatsquiz.laligastatsquiz.data.ResponsePlayerCompetition;
import com.laligastatsquiz.laligastatsquiz.tools.wsLaLiga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LstPlayersRankingModel implements LstPlayersRankingContract.Model {

    private OnLstPlayersRankingListener onLstPlayersRankingListener;
    private String college, leagueID, overallPick, roundNum, roundPick, season, teamID, topX, limit, offset, orderField, orderType, liga, newSeason, newLiga, tipo, country;
    private JsonObject jsonObject;
    private ArrayList<PlayerCompetition> playerCompetitions;
    private Bundle params;
    private ResponsePlayerCompetition responsePlayerCompetition;
    private ResponsePlayerCompetition playerCompetitionList;


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

        new PeticionGetPlayerCompetitions().execute();

    }

    public class PeticionGetPlayerCompetitions extends AsyncTask<Void, Void, Boolean> {

        public PeticionGetPlayerCompetitions() {
            super();

        }

        @Override
        protected Boolean doInBackground(Void... voids) {

            jsonObject = new JsonObject();
            playerCompetitions = new ArrayList<>();


            String statsJson;
            season = params.getString("season");
            liga = params.getString("liga");

            newSeason = params.getString("season");
            newLiga = params.getString("liga");
            tipo = params.getString("tipo");
            country = params.getString("country");

            String url = "https://apim.laliga.com/public-service/api/v1/subscriptions/" + liga + season + "/";

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
//                            .addHeader("Ocp-Apim-Subscription-Key", "c13c3a8e2f6b46da9c5c425cf61fab3e")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });


            OkHttpClient client = httpClient.build();

//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(url)
//                    .addConverterFactory(GsonConverterFactory
//                            .create()).client(client).build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://ii8tkqveae.execute-api.eu-west-3.amazonaws.com/borsoccer/")
                    .addConverterFactory(GsonConverterFactory
                            .create()).client(client).build();
            wsLaLiga service = retrofit.create(wsLaLiga.class);


            Call<JsonObject> response = service.getPlayersRanking(limit, offset, orderField, orderType);

//            String myBodyStr = "{\n" +
//                    "  \"stat\": \"goals\",\n" +
//                    "  \"season\": \"2006-2007\",\n" +
//                    "  \"competition\": 1\n" +
//                    "}";

//            String myBodyStr2 = "{\n" +
//                    "  \"stat\": \"goals\",\n" +
//                    "  \"season\": \""+newSeason+"\",\n" +
//                    "  \"competition\": "+newLiga+"\n" +
//                    "  \"tipo\": "+newLiga+"\n" +
//                    "  \"country\": "+newLiga+"\n" +
//                    "}";

            String myBodyStr = "{\n";
            myBodyStr = myBodyStr.concat("  \"stat\": \"goals\"");
            if(newSeason != null && !"".equalsIgnoreCase(newSeason)){
                myBodyStr = myBodyStr.concat(",\n  \"season\": \""+newSeason+"\"");
            }
            if(newLiga != null && !"".equalsIgnoreCase(newLiga)){
                myBodyStr = myBodyStr.concat(",\n  \"competition\": "+newLiga);
            }
            if(tipo != null && !"".equalsIgnoreCase(tipo)){
                myBodyStr = myBodyStr.concat(",\n  \"tipo\": "+tipo);
            }
            if(country != null && !"".equalsIgnoreCase(country)){
                myBodyStr = myBodyStr.concat(",\n  \"country\": "+country);
            }
            myBodyStr = myBodyStr.concat("\n}");
            JsonParser parser = new JsonParser();

            JsonObject myBody = parser.parse(myBodyStr).getAsJsonObject();
            Call<JsonObject> response2 = service.postJson(myBody);

            System.out.println("");
            //            String myRequest = response.request().header("x-nba-stats-origin").toString();
//            String my2 = response.request().header("Referer").toString();
//            String myurl = response.request().url().toString();

            try {
                statsJson = new Gson().toJson(response2.execute().body());

                String h = "";
//                statsJson = new Gson().toJson(response.execute().body());

                if (statsJson == null) {
                    return false;
                }

                // laLigaPlayerCall = new Gson().fromJson(statsJson, LaLigaPlayerCall.class);

                playerCompetitionList = new Gson().fromJson(statsJson, ResponsePlayerCompetition.class);

                for(PlayerCompetition playerCompetition: playerCompetitionList.getPlayerCompetitionList()){
                    playerCompetitions.add(playerCompetition);
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
                    onLstPlayersRankingListener.onFinished(playerCompetitions);
                } else {
                    onLstPlayersRankingListener.onFailure("No hay jugadores para esa selección");
                }

            } catch (Exception e) {

                onLstPlayersRankingListener.onFailure("Error: Listar Jugadores");

            }
        }


    }
}
