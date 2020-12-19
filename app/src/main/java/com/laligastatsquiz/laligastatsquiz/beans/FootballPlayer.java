package com.laligastatsquiz.laligastatsquiz.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FootballPlayer {
    private String id;
    private String name;
    private String nickname;
    private FootballPosition position;
    private FootballTeam team;
    private ArrayList<FootballStat> stats;
    private FootballPhoto photos;
    @SerializedName("opta_id")
    private String optaId;

    public FootballPlayer(String id, String name, String nickname, FootballPosition position, FootballTeam team, ArrayList<FootballStat> stats, FootballPhoto photos, String optaId) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.position = position;
        this.team = team;
        this.stats = stats;
        this.photos = photos;
        this.optaId = optaId;
    }

    public FootballPlayer() {
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

    public FootballPosition getPosition() {
        return position;
    }

    public void setPosition(FootballPosition position) {
        this.position = position;
    }

    public FootballTeam getTeam() {
        return team;
    }

    public void setTeam(FootballTeam team) {
        this.team = team;
    }

    public ArrayList<FootballStat> getStats() {
        return stats;
    }

    public void setStats(ArrayList<FootballStat> stats) {
        this.stats = stats;
    }

    public FootballPhoto getPhotos() {
        return photos;
    }

    public void setPhotos(FootballPhoto photos) {
        this.photos = photos;
    }

    public String getOptaId() {
        return optaId;
    }

    public void setOptaId(String optaId) {
        this.optaId = optaId;
    }

    @Override
    public String toString() {
        return nickname;
    }
}
