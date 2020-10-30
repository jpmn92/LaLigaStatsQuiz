package com.laligastatsquiz.laligastatsquiz.competiciones;

public enum LigaEuropea implements Competicion{

    SANTANDER(1, "La Liga Santander"),
    SMARRBANK(2, "La Liga Smartbank 2"),
    PREMIER(3, "Premier League"),
    BUNDESLIGA(6, "Bundesliga"),
    LIGUE1(7, "Ligue 1"),
    SERIEA(8, "Serie A");


    private int id;
    private String name;

    LigaEuropea(int id, String name) {
        this.id = id;
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
