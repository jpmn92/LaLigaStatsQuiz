package com.laligastatsquiz.laligastatsquiz.competiciones;

import android.content.res.Resources;

import com.laligastatsquiz.laligastatsquiz.GameActivity;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.fragments.FragmentoMenu;

public enum LigaEuropea implements Competicion {

    SANTANDER(1, "La Liga Santander", "https://a.espncdn.com/combiner/i?img=/i/leaguelogos/soccer/500/15.png&transparent=true&w=288&h=288", 1),
    SMARRBANK(2, "La Liga Smartbank 2", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/LaLiga_SmartBank.svg/1200px-LaLiga_SmartBank.svg.png", 1),
    PREMIER(3, "Premier League", "https://www.transfermarkt.es/images/logo/originals/gb1.png?lm=1521104656", 2),
    BUNDESLIGA(6, "Bundesliga", "https://a.espncdn.com/combiner/i?img=/i/leaguelogos/soccer/500/10.png", 3),
    LIGUE1(7, "Ligue 1", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Ligue1.svg/1200px-Ligue1.svg.png", 4),
    SERIEA(8, "Serie A", "https://upload.wikimedia.org/wikipedia/commons/9/93/Serie_A_Logo_%28ab_2019%29.png", 5),
    //    MEZCLA(0, "All", "https://upload.wikimedia.org/wikipedia/en/thumb/5/5e/European_Leagues_logo.svg/1200px-European_Leagues_logo.svg.png", 0);
    MEZCLA(0, "All", "https://i.ibb.co/K2KLHVH/europeanleagues.png", 0);
    private int id;
    private String name;
    private String urlImage;
    private int tipo;
    private int country;

    LigaEuropea(int id, String name, String urlImage, int country) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
        this.country = country;
        this.tipo = 1;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUrlImage() {
        return urlImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}
