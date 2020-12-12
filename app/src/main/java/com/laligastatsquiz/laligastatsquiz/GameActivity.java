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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaStat;
import com.laligastatsquiz.laligastatsquiz.data.PlayerCompetition;
import com.laligastatsquiz.laligastatsquiz.lst_players_ranking.LstPlayersRankingContract;
import com.laligastatsquiz.laligastatsquiz.lst_players_ranking.LstPlayersRankingPresenter;
import com.laligastatsquiz.laligastatsquiz.tools.ColorApp;
import com.laligastatsquiz.laligastatsquiz.tools.Constantes;
import com.laligastatsquiz.laligastatsquiz.tools.FirebaseMethods;

import java.util.ArrayList;

public class GameActivity extends Activity implements View.OnClickListener, LstPlayersRankingContract.View {

    private FirebaseMethods firebaseMethods;
    private MyCountDownTimer myCountDownTimer;
    private LstPlayersRankingPresenter lstPlayersRankingPresenter;
    private ArrayList<PlayerCompetition> playerCompetitionArrayList;
    private ImageView ivPlayer1, ivPlayer2, ivTeam1, ivTeam2, ivVidas, ivCompetition1, ivCompetition2, ivLoad;
    private TextView txtP1, txtP2, txtNameP1, txtNameP2, txtPoints, txtPregunta, txtSeasonP1, txtSeasonP2;
    private RelativeLayout relFront;
    private LinearLayout linP1, linP2, linLoad;
    private MediaPlayer mediaPlayer;
    private ProgressBar progressBar;

    private int valueP1, valueP2;
    private PlayerCompetition player1;
    private PlayerCompetition player2;
    private boolean sound, crono, logeado;
    private String statName, stat, liga, season;
    private int contadorAciertos, vidas, points, tiempo, record, statId;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

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
//        liga = traducirLiga(this.getIntent().getStringExtra("liga"));

        if(!this.getIntent().getStringExtra("season").equalsIgnoreCase(getResources().getString(R.string.misc))) {
            season = this.getIntent().getStringExtra("season");
        }
        else{
            season = "";
        }

//        final String laliga = getString(R.string.liga_santander);
//        final String premier = getString(R.string.premier);
//        final String bundesliga = getString(R.string.bundesliga);
//        final String calcio = getString(R.string.seriea);
//        final String league1 = getString(R.string.league1);

        liga = String.valueOf(this.getIntent().getIntExtra("liga", 0));


        initComponents();
        params.putString("StatCategory", stat);
        params.putString("liga", liga);
//        season = "20" + this.getIntent().getStringExtra("season").substring(0, this.getIntent().getStringExtra("season").indexOf('/'));
//        season = "";



        params.putString("season", season);
        txtPregunta.setText(statName);
        relFront.setVisibility(View.INVISIBLE);
        txtPoints.setText(String.valueOf(points));
        lstPlayersRankingPresenter.getPlayersRanking(params);
    }

    private void inicializarPublicidad() {
        MobileAds.initialize(this);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5187656956047852/2422488014"); //Este es el nuestro
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if(crono){
                    myCountDownTimer.start();
                }
            }
        });

        if(!Constantes.DEVELOPER_MODE){
            mAdView = findViewById(R.id.adViewGame);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            mAdView.setAdListener(new AdListener(){
                @Override
                public void onAdClosed() {
                    mAdView.loadAd(new AdRequest.Builder().build());
                }
            });
        }

    }

    private void initComponents() {
        firebaseMethods = new FirebaseMethods(this, this.getIntent().getExtras());
        crono = this.getIntent().getBooleanExtra("crono", true);
        sound = this.getIntent().getBooleanExtra("sound", true);
        logeado = this.getIntent().getBooleanExtra("loged", false);
        ivTeam1 = findViewById(R.id.ivTeam1);
        ivTeam2 = findViewById(R.id.ivTeam2);
        ivPlayer1 = findViewById(R.id.ivPlayer1);
        ivPlayer2 = findViewById(R.id.ivPlayer2);
        ivCompetition1 = findViewById(R.id.ivCompetition1);
        ivCompetition2 = findViewById(R.id.ivCompetition2);
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
        txtSeasonP1 = findViewById(R.id.txtSeasonP1);
        txtSeasonP2 = findViewById(R.id.txtSeasonP2);
        txtPoints = findViewById(R.id.txtPuntuacion);
        txtPregunta = findViewById(R.id.txtPregunta);
        vidas = 3;
        points = 0;
        tiempo = 10000;
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
                if(crono){
                    myCountDownTimer.start();
                }
            }
        }, 5000);
    }

    private void selectPlayers() {
        // comprobarSinFoto(); // Metodo de momento para buscar jugadores sin foto
        int randomP1;
        int randomP2;

        randomP1 = (int) (Math.random() * (playerCompetitionArrayList.size()));
        player1 = playerCompetitionArrayList.get(randomP1);
        if (stat.equalsIgnoreCase("goals")) {
            valueP1 = player1.getGoals();
        }

        do {
            randomP2 = (int) (Math.random() * (playerCompetitionArrayList.size()));
            player2 = playerCompetitionArrayList.get(randomP2);
        } while (randomP2 == randomP1);

        if (stat.equalsIgnoreCase("goals")) {
            valueGoles();
        } else if (stat.equalsIgnoreCase("assist")) {
            valueAsistencias();
        } else if (stat.equalsIgnoreCase("mezcla")) {
            int random = (int) (Math.random() * 2) + 1;
            if (random == 1) {
                valueGoles();
                txtPregunta.setText(getString(R.string.goles_anotados));
            } else if (random == 2) {
                valueAsistencias();
                txtPregunta.setText(getString(R.string.asistencias));
            }
        }

        showPlayers();
        if(crono){
            myCountDownTimer.start();
        }
    }

    /**
     * Metodo para que el valor a comparar sean los goles
     */
    private void valueGoles() {
        valueP1 = player1.getGoals();
        valueP2 = player2.getGoals();
    }

    /**
     * Metodo para que el valor a comparar sean las asistencias
     */
    private void valueAsistencias() {
        valueP1 = player1.getAssists();
        valueP2 = player2.getAssists();
    }

    /**
     * Metodo para ver que jugadores no tienen foto
     */
//    private void comprobarSinFoto() {
//        ArrayList<LaLigaPlayer> laLigaPlayersSinFoto = new ArrayList<>();
//        for(PlayerCompetition playerCompetition: playerCompetitionArrayList){
//            if(playerCompetition.getPhotos() == null){
//                laLigaPlayersSinFoto.add(laLigaPlayer);
//                System.out.println("SIN FOTO " + laLigaPlayer.getNickname());
//            }
//        }
//        System.out.println("PUNTO DE RUPTURA");
//    }
    private int calculateValue(LaLigaPlayer laLigaPlayer, String stat) {
        int statValue = 0;
        for (LaLigaStat laLigaStat : laLigaPlayer.getStats()) {

            if (laLigaStat.getName().equals(stat)) {
                statValue = Integer.valueOf(laLigaStat.getStat());
            }
        }

        return statValue;
    }

    private void showPlayers() {
        if (player1.getUrlPlayerPhoto() != null) {
            Glide.with(this).load(String.valueOf(player1.getUrlPlayerPhoto())).transition(DrawableTransitionOptions.withCrossFade()).override(1024, 1113).into(ivPlayer1);
            Glide.with(this).load(String.valueOf(player1.getUrlTeamPhoto())).transition(DrawableTransitionOptions.withCrossFade()).into(ivTeam1);
            Glide.with(this).load(String.valueOf(player1.getUrlCompetitionPhoto())).transition(DrawableTransitionOptions.withCrossFade()).into(ivCompetition1);
        } else {
            Glide.with(this).load("https://fmdataba.com/images/p/" + String.valueOf(player1.getIdfm()) + ".png").transition(DrawableTransitionOptions.withCrossFade()).override(1024, 1113).into(ivPlayer1);
            Glide.with(this).load(String.valueOf(player1.getUrlTeamPhoto())).transition(DrawableTransitionOptions.withCrossFade()).into(ivTeam1);
            Glide.with(this).load(String.valueOf(player1.getUrlCompetitionPhoto())).transition(DrawableTransitionOptions.withCrossFade()).into(ivCompetition1);
         }

        if (player2.getUrlPlayerPhoto() != null) {
            Glide.with(this).load(String.valueOf(player2.getUrlPlayerPhoto())).transition(DrawableTransitionOptions.withCrossFade()).override(1024, 1113).into(ivPlayer2);
            Glide.with(this).load(String.valueOf(player2.getUrlTeamPhoto())).transition(DrawableTransitionOptions.withCrossFade()).into(ivTeam2);
            Glide.with(this).load(String.valueOf(player2.getUrlCompetitionPhoto())).transition(DrawableTransitionOptions.withCrossFade()).into(ivCompetition2);
        } else {
            Glide.with(this).load("https://fmdataba.com/images/p/" + String.valueOf(player2.getIdfm()) + ".png").transition(DrawableTransitionOptions.withCrossFade()).override(1024, 1113).into(ivPlayer2);
            Glide.with(this).load(String.valueOf(player2.getUrlTeamPhoto())).transition(DrawableTransitionOptions.withCrossFade()).into(ivTeam2);
            Glide.with(this).load(String.valueOf(player2.getUrlCompetitionPhoto())).transition(DrawableTransitionOptions.withCrossFade()).into(ivCompetition2);
        }

//        txtNameP1.setText(player1.getNickname());
//        txtNameP2.setText(player2.getNickname());
        txtNameP1.setText(player1.getName() + " " + player1.getLastName());
        txtNameP2.setText(player2.getName() + " " + player2.getLastName());

        txtSeasonP1.setText(player1.getSeason());
        txtSeasonP2.setText(player2.getSeason());
    }

    private void acierto() {

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
    }

    private void finishGame() {

        if (checkInternetConnection() == true) {
            String message = "";
            //TODO: Cuando implementemos el logeo hay que descomentar estas lineas

            if (logeado && crono) {
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

    private void iluminar(String color) {
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
        if (logeado && crono) {
            firebaseMethods.getRecord();
        }

    }


    @Override
    public void successListPlayersRanking(ArrayList<PlayerCompetition> playerCompetitions) {
        setPlayerCompetitionArrayList(playerCompetitions);
        selectPlayers();

    }

    @Override
    public void failureListPlayersRanking(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(false);
        builder.setTitle(R.string.no_data_found);
        builder.setPositiveButton(R.string.back_to_menu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                onBackPressed();
//                Intent menu = new Intent(GameActivity.this, Menu.class);
//                menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                GameActivity.this.startActivity(menu);
            }
        });
        builder.show();
    }

    @Override
    public void onClick(View view) {
        myCountDownTimer.cancel();
        switch (view.getId()) {
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

    public ArrayList<PlayerCompetition> getPlayerCompetitionArrayList() {
        return playerCompetitionArrayList;
    }

    public void setPlayerCompetitionArrayList(ArrayList<PlayerCompetition> playerCompetitionArrayList) {
        this.playerCompetitionArrayList = playerCompetitionArrayList;
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

    private String traducirEstadistica(String statCategory) {
        String stat = "";
        if (statCategory.equalsIgnoreCase(getString(R.string.goles_anotados))) {
            stat = "goals";
            statId = R.string.goles_anotados;
        } else if (statCategory.equalsIgnoreCase(getString(R.string.asistencias))) {
            stat = "assist";
            statId = R.string.asistencias;
        } else if (statCategory.equalsIgnoreCase(getString(R.string.misc))) {
            stat = "mezcla";
            statId = R.string.misc;
        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.pases_completados))){
//            stat = "total_accurate_pass";
//            statId = R.string.pases_completados;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.paradas))){
//            stat = "total_saves";
//            statId = R.string.paradas;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.tarjetas_amarillas))){
//            stat = "total_yellow_card";
//            statId = R.string.tarjetas_amarillas;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.tarjetas_rojas))){
//            stat = "total_red_card";
//            statId = R.string.tarjetas_rojas;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.penaltis))){
//            stat = "total_att_pen_goal";
//            statId = R.string.penaltis;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.goles_falta))){
//            stat = "total_att_freekick_goal";
//            statId = R.string.goles_falta;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.entradas_exitosas))){
//            stat = "total_won_tackle";
//            statId = R.string.entradas_exitosas;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.minutos))){
//            stat = "total_mins_played";
//            statId = R.string.minutos;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.tarjetas))){
//            stat = "total_card";
//            statId = R.string.tarjetas;
//        }
//        else if(statCategory.equalsIgnoreCase(getString(R.string.faltas))){
//            stat = "total_fouls";
//            statId = R.string.faltas;
//        }

        return stat;
    }

    private String traducirLiga(String ligaName) {
        String liga = "";
        if (ligaName.equalsIgnoreCase(getString(R.string.liga_santander))) {
            liga = "laliga-santander-";
        } else if (ligaName.equalsIgnoreCase(getString(R.string.liga_smartbank))) {
            liga = "laliga-smartbank-";
        }
//        else if(ligaName.equalsIgnoreCase(getString(R.string.liga_femenina))){
//            liga = "primera-division-femenina-";
//        }
//        else if(ligaName.equalsIgnoreCase(getString(R.string.liga_1_2_3))){
//            liga = "laliga-1-2-3-";
//        }

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
                if (!Constantes.DEVELOPER_MODE && mInterstitialAd.isLoaded()) {
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
                if (!Constantes.DEVELOPER_MODE && mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                onBackPressed();

            }
        });
        builder.show();
    }

    /**
     * Metodo para generar en consola un texto con los jugadores y sus imagenes
     *
     * @param laLigaPlayers
     */
    private void generarJugadorConSuImagen(ArrayList<LaLigaPlayer> laLigaPlayers) {
        for (LaLigaPlayer laLigaPlayer1 : laLigaPlayers) {
            System.out.println("laLigaPlayer = generatePlayer(\"" + laLigaPlayer1.getNickname() + "\", \"" + laLigaPlayer1.getPhotos().getPhoto().getMedium() + "\");\n" +
                    "laLigaPlayers.add(laLigaPlayer);\n\n");
        }
    }

    private boolean image2B(String teamID) {
        return teamID.equalsIgnoreCase("219") || teamID.equalsIgnoreCase("166")
                || teamID.equalsIgnoreCase("23") || teamID.equalsIgnoreCase("37")
                || teamID.equalsIgnoreCase("38") || teamID.equalsIgnoreCase("304")
                || teamID.equalsIgnoreCase("9") || teamID.equalsIgnoreCase("290")
                || teamID.equalsIgnoreCase("288") || teamID.equalsIgnoreCase("284");
    }

    private String imagePlayer(String teamID) {
        String imageUrl = "";
        switch (teamID) {
            case "219": // Athletic
                imageUrl = "https://assets.laliga.com/squad/2019/" + "t174" + "/default/1024x1024/default_" + "t174" + "_2019_1_003_000.png";
                break;
            case "166": //Llagostera
                imageUrl = "https://bowlofricedev.jdevcloud.com/wp-content/uploads/2020/07/llagostera.png";
                break;
            case "23": // Barça
                imageUrl = "https://assets.laliga.com/squad/2019/" + "t178" + "/default/1024x1024/default_" + "t178" + "_2019_1_003_000.png";
                break;
            case "37": // Recre
                imageUrl = "https://bowlofricedev.jdevcloud.com/wp-content/uploads/2020/07/recre.png";
                break;
            case "38": // Sabadell
                imageUrl = "https://bowlofricedev.jdevcloud.com/wp-content/uploads/2020/07/sabadell.png";
                break;
            case "304": // Murcia
                imageUrl = "https://bowlofricedev.jdevcloud.com/wp-content/uploads/2020/07/murcia.png";
                break;
            case "9": // Getafe
                imageUrl = "https://assets.laliga.com/squad/2019/" + "t1450" + "/default/1024x1024/default_" + "t1450" + "_2019_1_003_000.png";
                break;
            case "290": //Sevilla
                imageUrl = "https://assets.laliga.com/squad/2019/" + "t179" + "/default/1024x1024/default_" + "t179" + "_2019_1_003_000.png";
                break;
            case "288": //Llora
                imageUrl = "https://bowlofricedev.jdevcloud.com/wp-content/uploads/2020/07/lorca.png";
                break;
            case "284": //Cultural
                imageUrl = "https://bowlofricedev.jdevcloud.com/wp-content/uploads/2020/07/cultural.png";
                break;
        }


        return imageUrl;
    }

    //GETTERS Y SETTERS
    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }
}
