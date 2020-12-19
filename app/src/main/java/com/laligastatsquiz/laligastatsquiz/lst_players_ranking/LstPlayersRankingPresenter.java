package com.laligastatsquiz.laligastatsquiz.lst_players_ranking;

import android.os.Bundle;

import com.laligastatsquiz.laligastatsquiz.beans.FootballPlayer;
import com.laligastatsquiz.laligastatsquiz.data.PlayerCompetition;

import java.util.ArrayList;

public class LstPlayersRankingPresenter implements LstPlayersRankingContract.Presenter{

    private LstPlayersRankingContract.View vista;
    private LstPlayersRankingModel modelo;

    public LstPlayersRankingPresenter(LstPlayersRankingContract.View vista) {
        this.vista = vista;
        this.modelo = new LstPlayersRankingModel();
    }

    @Override
    public void getPlayersRanking(Bundle params) {

        this.modelo.getPlayersRankingService(new LstPlayersRankingContract.Model.OnLstPlayersRankingListener() {
            @Override
            public void onFinished(ArrayList<PlayerCompetition> playerCompetitions) {
                vista.successListPlayersRanking(playerCompetitions);
            }

            @Override
            public void onFailure(String error) {
                vista.failureListPlayersRanking(error);
            }
        }, params);



    }
}

