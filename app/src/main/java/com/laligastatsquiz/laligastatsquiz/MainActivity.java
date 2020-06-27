package com.laligastatsquiz.laligastatsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaStat;
import com.laligastatsquiz.laligastatsquiz.lst_players_ranking.LstPlayersRankingContract;
import com.laligastatsquiz.laligastatsquiz.lst_players_ranking.LstPlayersRankingPresenter;
import com.laligastatsquiz.laligastatsquiz.tools.ColorApp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LstPlayersRankingContract.View {

    private LstPlayersRankingPresenter lstPlayersRankingPresenter;
    private ArrayList<LaLigaPlayer> laLigaPlayerArrayList;
    private Context context;
    private ImageView ivPlayer1, ivPlayer2, ivTeam1, ivTeam2;
    private TextView txtP1, txtP2, txtNameP1, txtNameP2;
    private RelativeLayout relFront;
    private LinearLayout linP1, linP2;
    private int valueP1, valueP2;
    private LaLigaPlayer player1;
    private LaLigaPlayer player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPlayersRankingPresenter = new LstPlayersRankingPresenter(this);
        Bundle params = new Bundle();
        initComponents();
        relFront.setVisibility(View.INVISIBLE);
        // params.putString();
        lstPlayersRankingPresenter.getPlayersRanking(params);
        context = this;
    }

    private void initComponents() {
        ivTeam1 = findViewById(R.id.ivTeam1);
        ivTeam2 = findViewById(R.id.ivTeam2);
        ivPlayer1 = findViewById(R.id.ivPlayer1);
        ivPlayer2 = findViewById(R.id.ivPlayer2);
        relFront = findViewById(R.id.relFront);
        linP1 = findViewById(R.id.linP1);
        linP1.setOnClickListener(this);
        linP2 = findViewById(R.id.linP2);
        linP2.setOnClickListener(this);
        txtP1 = findViewById(R.id.txtP1);
        txtNameP1 = findViewById(R.id.txtNameP1);
        txtP2 = findViewById(R.id.txtP2);
        txtNameP2 = findViewById(R.id.txtNameP2);

    }

    private void selectPlayers() {
        int randomP1 = (int) (Math.random() * (laLigaPlayerArrayList.size()));
        int randomP2 = (int) (Math.random() * (laLigaPlayerArrayList.size()));
        player1 = laLigaPlayerArrayList.get(randomP1);
        player2 = laLigaPlayerArrayList.get(randomP2);
        System.out.println("ERROR EN: " + player1.getName());

        showPlayers();
        String statName = "total_goals"; // Aqui habrá que crear un método que devuelva un string con el nombre de la estadística deseada
        valueP1 = calculateValue(player1, statName);
        valueP2 = calculateValue(player2, statName);

    }

    private int calculateValue(LaLigaPlayer laLigaPlayer, String statName) {
        int stat = 0;
        for(LaLigaStat laLigaStat: laLigaPlayer.getStats()){

            if(laLigaStat.getName().equals(statName)){
                stat = Integer.valueOf(laLigaStat.getStat());
            }
        }
        return stat;
    }

    private void showPlayers() {
        // Toko ekambi y nolito no tienen foto y peta cuando salen
        System.out.println("P1: " + player1.getName());
        System.out.println("P2: " + player2.getName());

        Picasso.with(this).load(String.valueOf(player1.getPhotos().getPhoto().getBig())).into(ivPlayer1);
        Picasso.with(this).load(String.valueOf(player1.getTeam().getShield().getUrl())).into(ivTeam1);

        Picasso.with(this).load(String.valueOf(player2.getPhotos().getPhoto().getBig())).into(ivPlayer2);
        Picasso.with(this).load(String.valueOf(player2.getTeam().getShield().getUrl())).into(ivTeam2);

        txtNameP1.setText(player1.getNickname());
        txtNameP2.setText(player2.getNickname());
    }

    private void acierto(){
        iluminar(ColorApp.GREEN);
        selectPlayers();
    }

    private void fallo(){
        iluminar(ColorApp.RED);
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
}
