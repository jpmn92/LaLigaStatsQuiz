package com.laligastatsquiz.laligastatsquiz.lst_players_ranking;

import android.os.Bundle;

import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;
import com.laligastatsquiz.laligastatsquiz.data.PlayerCompetition;

import java.util.ArrayList;

public interface LstPlayersRankingContract {

    public interface View{
        void successListPlayersRanking(ArrayList<PlayerCompetition> playerCompetitions);
        void failureListPlayersRanking(String message);
    }

    public interface Presenter{
        void getPlayersRanking(Bundle params);
    }

    public interface Model{
        interface OnLstPlayersRankingListener{
            void onFinished(ArrayList<PlayerCompetition> draftPicks);
            void onFailure(String error);
        }

        void getPlayersRankingService(

                OnLstPlayersRankingListener onLstDraftListener, Bundle params
        );
    }
}
