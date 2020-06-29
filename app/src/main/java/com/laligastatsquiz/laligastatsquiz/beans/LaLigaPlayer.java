package com.laligastatsquiz.laligastatsquiz.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LaLigaPlayer {
    private String id;
    private String name;
    private String nickname;
    private LaLigaPosition position;
    private LaLigaTeam team;
    private ArrayList<LaLigaStat> stats;
    private LaLigaPhoto photos;
    @SerializedName("opta_id")
    private String optaId;

    public LaLigaPlayer(String id, String name, String nickname, LaLigaPosition position, LaLigaTeam team, ArrayList<LaLigaStat> stats, LaLigaPhoto photos, String optaId) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.position = position;
        this.team = team;
        this.stats = stats;
        this.photos = photos;
        this.optaId = optaId;
    }

    public LaLigaPlayer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LaLigaPosition getPosition() {
        return position;
    }

    public void setPosition(LaLigaPosition position) {
        this.position = position;
    }

    public LaLigaTeam getTeam() {
        return team;
    }

    public void setTeam(LaLigaTeam team) {
        this.team = team;
    }

    public ArrayList<LaLigaStat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<LaLigaStat> stats) {
        this.stats = stats;
    }

    public LaLigaPhoto getPhotos() {
        return photos;
    }

    public void setPhotos(LaLigaPhoto photos) {
        this.photos = photos;
    }

    public String getOptaId() {
        return optaId;
    }

    public void setOptaId(String optaId) {
        this.optaId = optaId;
    }
}
