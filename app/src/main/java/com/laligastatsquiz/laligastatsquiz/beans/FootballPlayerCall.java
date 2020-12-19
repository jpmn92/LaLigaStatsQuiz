package com.laligastatsquiz.laligastatsquiz.beans;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FootballPlayerCall {
    private String total;
    private ArrayList<FootballPlayer> player_rankings;

    public FootballPlayerCall(String total, ArrayList<FootballPlayer> player_rankings) {
        this.total = total;
        this.player_rankings = player_rankings;
    }

    public FootballPlayerCall() {
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<FootballPlayer> getPlayer_rankings() {
        return player_rankings;
    }

    public void setPlayer_rankings(ArrayList<FootballPlayer> player_rankings) {
        this.player_rankings = player_rankings;
    }
}
