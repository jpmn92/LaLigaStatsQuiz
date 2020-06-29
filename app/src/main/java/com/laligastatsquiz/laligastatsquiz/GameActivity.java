package com.laligastatsquiz.laligastatsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaStat;
import com.laligastatsquiz.laligastatsquiz.lst_players_ranking.LstPlayersRankingContract;
import com.laligastatsquiz.laligastatsquiz.lst_players_ranking.LstPlayersRankingPresenter;
import com.laligastatsquiz.laligastatsquiz.tools.ColorApp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener, LstPlayersRankingContract.View {

    private MyCountDownTimer myCountDownTimer;
    private LstPlayersRankingPresenter lstPlayersRankingPresenter;
    private ArrayList<LaLigaPlayer> laLigaPlayerArrayList;
    private ImageView ivPlayer1, ivPlayer2, ivTeam1, ivTeam2, ivVidas;
    private TextView txtP1, txtP2, txtNameP1, txtNameP2, txtPoints, txtPregunta;
    private RelativeLayout relFront;
    private LinearLayout linP1, linP2, linLoad;
    private MediaPlayer mediaPlayer;
    private ProgressBar progressBar;

    private int valueP1, valueP2;
    private LaLigaPlayer player1;
    private LaLigaPlayer player2;
    private boolean sound;
    private String statName, stat;
    private int contadorAciertos, vidas, points, tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle params = new Bundle();
        lstPlayersRankingPresenter = new LstPlayersRankingPresenter(this);
        initComponents();
        statName = this.getIntent().getStringExtra("stat");
        stat = traducirEstadistica(statName);
        txtPregunta.setText(statName);
        params.putString("StatCategory", stat);
        relFront.setVisibility(View.INVISIBLE);
        txtPoints.setText(String.valueOf(points));
        lstPlayersRankingPresenter.getPlayersRanking(params);
    }

    private void initComponents() {
        sound = this.getIntent().getBooleanExtra("sound", true); // se tendrá que pasar por parametro
        ivTeam1 = findViewById(R.id.ivTeam1);
        ivTeam2 = findViewById(R.id.ivTeam2);
        ivPlayer1 = findViewById(R.id.ivPlayer1);
        ivPlayer2 = findViewById(R.id.ivPlayer2);
        ivVidas = findViewById(R.id.ivVidas);
        relFront = findViewById(R.id.relFront);
        linP1 = findViewById(R.id.linP1);
        linP1.setOnClickListener(this);
        linP2 = findViewById(R.id.linP2);
        linP2.setOnClickListener(this);
        txtP1 = findViewById(R.id.txtP1);
        txtNameP1 = findViewById(R.id.txtNameP1);
        txtP2 = findViewById(R.id.txtP2);
        txtNameP2 = findViewById(R.id.txtNameP2);
        txtPoints = findViewById(R.id.txtPuntuacion);
        txtPregunta = findViewById(R.id.txtPregunta);
        vidas = 3;
        points = 0;
        tiempo = 10000;
        myCountDownTimer = new MyCountDownTimer(tiempo, 1000);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        linLoad = findViewById(R.id.linLoad);
        final ProgressDialog progressDialog = new ProgressDialog(GameActivity.this, R.style.Theme_AppCompat_DayNight_Dialog); //TODO: RECIEN CAMBIADO 16/06
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();
        linLoad.postDelayed(new Runnable() {
            public void run() {
                linLoad.setVisibility(View.GONE);
                progressDialog.dismiss();

            }
        }, 3000);

    }

    private void selectPlayers() {
        // comprobarSinFoto(); // Metodo de momento para buscar jugadores sin foto
        int randomP1;
        int randomP2;
        do{
            randomP1 = (int) (Math.random() * (laLigaPlayerArrayList.size()));
            player1 = laLigaPlayerArrayList.get(randomP1);
        } while (player1.getPhotos() == null);
        do{
            randomP2 = (int) (Math.random() * (laLigaPlayerArrayList.size()));
            player2 = laLigaPlayerArrayList.get(randomP2);
        } while (randomP2 == randomP1 || player2.getPhotos() == null);


        showPlayers();


        valueP1 = calculateValue(player1, stat);
        valueP2 = calculateValue(player2, stat);

    }

    private void comprobarSinFoto() {
        ArrayList<LaLigaPlayer> laLigaPlayersSinFoto = new ArrayList<>();
        for(LaLigaPlayer laLigaPlayer: laLigaPlayerArrayList){
            if(laLigaPlayer.getPhotos() == null){
                laLigaPlayersSinFoto.add(laLigaPlayer);
                System.out.println("SIN FOTO " + laLigaPlayer.getNickname());
            }
        }
        System.out.println("PUNTO DE RUPTURA");
    }

    private int calculateValue(LaLigaPlayer laLigaPlayer, String stat) {
        int statValue = 0;
        for(LaLigaStat laLigaStat: laLigaPlayer.getStats()){

            if(laLigaStat.getName().equals(stat)){
                statValue = Integer.valueOf(laLigaStat.getStat());
            }
        }
        myCountDownTimer.start();
        return statValue;
    }

    private void showPlayers() {
        // En trello estan los jugadores sin foto
        System.out.println("P1: " + player1.getName());
        System.out.println("P2: " + player2.getName());

//        String url = "https://e00-marca.uecdn.es/iconos/escudos/opta/jugadores/" + player1.getOptaId().substring(1) + ".jpg";
//        Picasso.with(this).load(url).into(ivPlayer1);
        Picasso.with(this).load(String.valueOf(player1.getPhotos().getPhoto().getBig())).into(ivPlayer1);
        Picasso.with(this).load(String.valueOf(player1.getTeam().getShield().getUrl())).into(ivTeam1);

//        url = "https://e00-marca.uecdn.es/iconos/escudos/opta/jugadores/" + player2.getOptaId().substring(1) + ".jpg";
//        Picasso.with(this).load(url).into(ivPlayer2);
        Picasso.with(this).load(String.valueOf(player2.getPhotos().getPhoto().getBig())).into(ivPlayer2);
        Picasso.with(this).load(String.valueOf(player2.getTeam().getShield().getUrl())).into(ivTeam2);

        txtNameP1.setText(player1.getNickname());
        txtNameP2.setText(player2.getNickname());
    }

    private void acierto(){

        if (sound) {
            mediaPlayer = MediaPlayer.create(this, R.raw.acierto);
            mediaPlayer.start();

        }
        iluminar(ColorApp.GREEN);
        contadorAciertos++;
        if (contadorAciertos >= 10 && vidas < 3) {
            vidas++;
            comprobarVidas();
            contadorAciertos = 0;
        }
        comprobarVidas();
        points++;
        txtPoints.setText(String.valueOf(points));
        selectPlayers();
    }

    private void fallo() {
        if (sound) {
            mediaPlayer = MediaPlayer.create(this, R.raw.error);
            mediaPlayer.start();

        }
        contadorAciertos = 0;
        iluminar(ColorApp.RED);
        vidas--;
        comprobarVidas();

        if (vidas <= 0) {
            // finishGame();
        } else {
            selectPlayers();
        }

        //continueGame();


    }

    private void comprobarVidas() {


        switch (vidas) {
            case 0:
                ivVidas.setImageResource(R.drawable.vidas0);
                break;
            case 1:
                ivVidas.setImageResource(R.drawable.vidas1);
                break;
            case 2:
                ivVidas.setImageResource(R.drawable.vidas2);
                break;
            case 3:
                ivVidas.setImageResource(R.drawable.vidas3);
                break;
        }
    }

    private void iluminar(String color){
        txtP1.setText(String.valueOf(valueP1));
        txtP2.setText(String.valueOf(valueP2));
        relFront.setBackgroundColor(Color.parseColor(color));
        relFront.setVisibility(View.VISIBLE);
        relFront.postDelayed(new Runnable() {
            public void run() {
                relFront.setVisibility(View.GONE);
            }
        }, 1000);
    }

    @Override
    public void successListPlayersRanking(ArrayList<LaLigaPlayer> laLigaPlayers) {
        //PRUEBA PARA MOSTRAR JUGADORES
        setLaLigaPlayerArrayList(laLigaPlayers);
        selectPlayers();

    }

    @Override
    public void failureListPlayersRanking(String message) {

    }

    @Override
    public void onClick(View view) {
        myCountDownTimer.cancel();
        switch (view.getId()){
            case R.id.linP1:
                if (valueP2 <= valueP1) {
                    acierto();
                } else {
                    fallo();
                }
                break;
            case R.id.linP2:
                if (valueP2 >= valueP1) {
                    acierto();
                } else {
                    fallo();
                }
                break;
        }
    }

    public ArrayList<LaLigaPlayer> getLaLigaPlayerArrayList() {
        return laLigaPlayerArrayList;
    }

    public void setLaLigaPlayerArrayList(ArrayList<LaLigaPlayer> laLigaPlayerArrayList) {
        this.laLigaPlayerArrayList = laLigaPlayerArrayList;
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

            int progress = (int) (millisUntilFinished / 1000);

            progressBar.setProgress(progressBar.getMax() - progress);
        }

        @Override
        public void onFinish() {
//            finish();
            myCountDownTimer.cancel();
            fallo();
        }
    }

    private Boolean checkInternetConnection() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;


        } else {
            connected = false;
        }

        return connected;

    }
    @Override
    protected void onPause() {
        super.onPause();
        myCountDownTimer.cancel();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myCountDownTimer.cancel();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myCountDownTimer.cancel();
        finish();
    }

    private String traducirEstadistica(String statCategory){
        String stat = "";
        String as = getString(R.string.goles_anotados);
        if(statCategory.equalsIgnoreCase(getString(R.string.goles_anotados))){
            stat = "total_goals";
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.asistencias))){
            stat = "total_assists";
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.pases_completados))){
            stat = "total_accurate_pass";
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.paradas))){
            stat = "total_saves";
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.tarjetas_amarillas))){
            stat = "total_yellow_card";
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.tarjetas_rojas))){
            stat = "total_red_card";
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.penaltis))){
            stat = "total_att_pen_goal";
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.goles_falta))){
            stat = "total_att_freekick_goal";
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.entradas_exitosas))){
            stat = "total_won_tackle";
        }

        return stat;
    }

}