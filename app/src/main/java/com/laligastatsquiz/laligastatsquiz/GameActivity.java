package com.laligastatsquiz.laligastatsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaStat;
import com.laligastatsquiz.laligastatsquiz.lst_players_ranking.LstPlayersRankingContract;
import com.laligastatsquiz.laligastatsquiz.lst_players_ranking.LstPlayersRankingPresenter;
import com.laligastatsquiz.laligastatsquiz.tools.ColorApp;
import com.laligastatsquiz.laligastatsquiz.tools.FirebaseMethods;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameActivity extends Activity implements View.OnClickListener, LstPlayersRankingContract.View {

    FirebaseMethods firebaseMethods;
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
    private String statName, stat, liga, season;
    private int contadorAciertos, vidas, points, tiempo, record, statId;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        inicializarPublicidad();

        Bundle params = new Bundle();
        lstPlayersRankingPresenter = new LstPlayersRankingPresenter(this);
        statName = this.getIntent().getStringExtra("stat");
        stat = traducirEstadistica(statName);
        this.getIntent().putExtra("statId", statId);
        liga = traducirLiga(this.getIntent().getStringExtra("liga"));
        initComponents();
        params.putString("StatCategory", stat);
        params.putString("liga", liga);
        season = "20" + this.getIntent().getStringExtra("season").substring(0, this.getIntent().getStringExtra("season").indexOf('/'));
        params.putString("season", season);
        txtPregunta.setText(statName + " " + this.getIntent().getStringExtra("season"));
        relFront.setVisibility(View.INVISIBLE);
        txtPoints.setText(String.valueOf(points));
        lstPlayersRankingPresenter.getPlayersRanking(params);
    }

    private void inicializarPublicidad() {
        MobileAds.initialize(this);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); //Este es el de prueba
        //mInterstitialAd.setAdUnitId("ca-app-pub-5187656956047852/2422488014"); //Este es el nuestro
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                System.out.println("PUBLI CERRADA");
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                myCountDownTimer.start();
            }
        });
    }

    private void initComponents() {
        firebaseMethods = new FirebaseMethods(this, this.getIntent().getExtras());
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
        //myCountDownTimer = new MyCountDownTimer(tiempo, 1000);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        linLoad = findViewById(R.id.linLoad);
        buscarRecord();
        final ProgressDialog progressDialog = new ProgressDialog(GameActivity.this, R.style.Theme_AppCompat_DayNight_Dialog); //TODO: RECIEN CAMBIADO 16/06
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();
        linLoad.postDelayed(new Runnable() {
            public void run() {
                linLoad.setVisibility(View.GONE);
                progressDialog.dismiss();
                myCountDownTimer = new MyCountDownTimer(tiempo, 1000);
                myCountDownTimer.start();
            }
        }, 5000);
    }

    private void selectPlayers() {
        // comprobarSinFoto(); // Metodo de momento para buscar jugadores sin foto
        int randomP1;
        int randomP2;

        randomP1 = (int) (Math.random() * (laLigaPlayerArrayList.size()));
        player1 = laLigaPlayerArrayList.get(randomP1);
        do{
            randomP2 = (int) (Math.random() * (laLigaPlayerArrayList.size()));
            player2 = laLigaPlayerArrayList.get(randomP2);
        } while (randomP2 == randomP1);


        showPlayers();


        valueP1 = calculateValue(player1, stat);
        valueP2 = calculateValue(player2, stat);
        myCountDownTimer.start();
    }

    /**
     * Metodo para ver que jugadores no tienen foto
     */
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

        return statValue;
    }

    private void showPlayers() {
        // En trello estan los jugadores sin foto
        System.out.println("P1: " + player1.getName());
        System.out.println("P2: " + player2.getName());

//        String url = "https://e00-marca.uecdn.es/iconos/escudos/opta/jugadores/" + player1.getOptaId().substring(1) + ".jpg";
//        Picasso.with(this).load(url).into(ivPlayer1);
        if(player1.getPhotos() != null){
            Picasso.with(this).load(String.valueOf(player1.getPhotos().getPhoto().getBig())).into(ivPlayer1);
            Picasso.with(this).load(String.valueOf(player1.getTeam().getShield().getUrl())).into(ivTeam1);
        }
        else{
            String imageP1Default = "https://assets.laliga.com/squad/2019/" + player1.getTeam().getOptaId() + "/default/1024x1024/default_" + player1.getTeam().getOptaId() + "_2019_1_003_000.png";
            Picasso.with(this).load(imageP1Default).into(ivPlayer1);
            Picasso.with(this).load(String.valueOf(player1.getTeam().getShield().getUrl())).into(ivTeam1);
        }

        if(player2.getPhotos() != null){
            Picasso.with(this).load(String.valueOf(player2.getPhotos().getPhoto().getBig())).into(ivPlayer2);
            Picasso.with(this).load(String.valueOf(player2.getTeam().getShield().getUrl())).into(ivTeam2);
        }
        else{
            String imageP2Default = "https://assets.laliga.com/squad/2019/" + player2.getTeam().getOptaId() + "/default/1024x1024/default_" + player2.getTeam().getOptaId() + "_2019_1_003_000.png";
            Picasso.with(this).load(imageP2Default).into(ivPlayer2);
            Picasso.with(this).load(String.valueOf(player2.getTeam().getShield().getUrl())).into(ivTeam2);
        }

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
            finishGame();
        } else {
            selectPlayers();
        }

        //continueGame();


    }

    private void finishGame() {

        if (checkInternetConnection() == true) {
            String message = "";
            //TODO: Cuando implementemos el logeo hay que descomentar estas lineas
            boolean logeado = this.getIntent().getBooleanExtra("loged", false);
            if (logeado) {
                FirebaseAuth mAuth;
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                this.getIntent().putExtra("userName", firebaseUser.getDisplayName());
                this.getIntent().putExtra("puntos", points);
                this.getIntent().putExtra("statId", statId);
                this.getIntent().putExtra("image", String.valueOf(firebaseUser.getPhotoUrl()));

                firebaseMethods.createFbPuntuacion(this.getIntent().getExtras());
                if (points > record) {
                    record = points;
                    message = getString(R.string.new_record) + "\n" + getString(R.string.puntuacion) + points;
                } else {
                    message = getString(R.string.puntuacion) + points + "\n" + getString(R.string.record) + record;
                }
            } else {
                message = getString(R.string.puntuacion) + points;
            }


            myCountDownTimer.cancel();
            showFinishedDialog(this, message);
        } else {
            myCountDownTimer.cancel();

            showFinishedDialog(this, "Internet connection lost");
        }


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
    private void buscarRecord() {
        if (this.getIntent().getBooleanExtra("loged", false)) {
            firebaseMethods.getRecord();
        }

    }


    @Override
    public void successListPlayersRanking(ArrayList<LaLigaPlayer> laLigaPlayers) {
        //PRUEBA PARA MOSTRAR JUGADORES
        setLaLigaPlayerArrayList(laLigaPlayers);
        // generarJugadorConSuImagen(laLigaPlayers);
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
        //finish();
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
        if(statCategory.equalsIgnoreCase(getString(R.string.goles_anotados))){
            stat = "total_goals";
            statId = R.string.goles_anotados;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.asistencias))){
            stat = "total_assists";
            statId = R.string.asistencias;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.pases_completados))){
            stat = "total_accurate_pass";
            statId = R.string.pases_completados;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.paradas))){
            stat = "total_saves";
            statId = R.string.paradas;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.tarjetas_amarillas))){
            stat = "total_yellow_card";
            statId = R.string.tarjetas_amarillas;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.tarjetas_rojas))){
            stat = "total_red_card";
            statId = R.string.tarjetas_rojas;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.penaltis))){
            stat = "total_att_pen_goal";
            statId = R.string.penaltis;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.goles_falta))){
            stat = "total_att_freekick_goal";
            statId = R.string.goles_falta;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.entradas_exitosas))){
            stat = "total_won_tackle";
            statId = R.string.entradas_exitosas;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.minutos))){
            stat = "total_mins_played";
            statId = R.string.minutos;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.tarjetas))){
            stat = "total_card";
            statId = R.string.tarjetas;
        }
        else if(statCategory.equalsIgnoreCase(getString(R.string.faltas))){
            stat = "total_fouls";
            statId = R.string.faltas;
        }

        return stat;
    }

    private String traducirLiga(String ligaName){
        String liga = "";
        if(ligaName.equalsIgnoreCase(getString(R.string.liga_santander))){
            liga = "laliga-santander-";
        }
        else if(ligaName.equalsIgnoreCase(getString(R.string.liga_smartbank))){
            liga = "laliga-smartbank-";
        }
        else if(ligaName.equalsIgnoreCase(getString(R.string.liga_femenina))){
            liga = "primera-division-femenina-";
        }

        return liga;
    }

    public void showFinishedDialog(Activity activity, CharSequence message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        builder.setTitle(R.string.game_finished);

        builder.setMessage(message);
        builder.setPositiveButton(R.string.play_again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int random = (int) (Math.random() * 2) + 1;
                if (mInterstitialAd.isLoaded() && random % 2 == 0) {
                    mInterstitialAd.show();
                }
                vidas = 3;
                points = 0;
                contadorAciertos = 0;
                txtPoints.setText(String.valueOf(points));
                comprobarVidas();
                selectPlayers();
            }
        });
        builder.setNegativeButton(R.string.back_to_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Intent menu = new Intent(GameActivity.this, NavigationDrawerActivity.class);
//                GameActivity.this.startActivity(menu);
//                GameActivity.this.finish();
                int random = (int) (Math.random() * 2) + 1;
                if (mInterstitialAd.isLoaded() && random % 2 == 0) {
                    mInterstitialAd.show();
                }
                onBackPressed();

            }
        });
        builder.show();
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    /**
     * Metodo para generar en consola un texto con los jugadores y sus imagenes
     * @param laLigaPlayers
     */
    private void generarJugadorConSuImagen(ArrayList<LaLigaPlayer> laLigaPlayers){
        for(LaLigaPlayer laLigaPlayer1: laLigaPlayers){
            System.out.println("laLigaPlayer = generatePlayer(\"" + laLigaPlayer1.getNickname() + "\", \"" + laLigaPlayer1.getPhotos().getPhoto().getMedium() + "\");\n" +
                    "laLigaPlayers.add(laLigaPlayer);\n\n");
        }
    }
}
