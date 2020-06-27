package com.laligastatsquiz.laligastatsquiz.beans;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LaLigaPlayerCall {
    private String total;
    private ArrayList<LaLigaPlayer> player_rankings;

    public LaLigaPlayerCall(String total, ArrayList<LaLigaPlayer> player_rankings) {
        this.total = total;
        this.player_rankings = player_rankings;
    }

    public LaLigaPlayerCall() {
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<LaLigaPlayer> getPlayer_rankings() {
        return player_rankings;
    }

    public void setPlayer_rankings(ArrayList<LaLigaPlayer> player_rankings) {
        this.player_rankings = player_rankings;
    }
}
