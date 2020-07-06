package com.laligastatsquiz.laligastatsquiz.beans;

import com.google.gson.annotations.SerializedName;

public class LaLigaTeam {
    private String id;
    private String name;
    private String nickname;
    private String shortname;
    private LaLigaShield shield;
    @SerializedName("opta_id")
    private String optaId;

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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public LaLigaShield getShield() {
        return shield;
    }

    public void setShield(LaLigaShield shield) {
        this.shield = shield;
    }

    public String getOptaId() {
        return optaId;
    }

    public void setOptaId(String optaId) {
        this.optaId = optaId;
    }
}
