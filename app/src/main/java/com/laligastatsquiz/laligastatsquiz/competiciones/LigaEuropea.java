package com.laligastatsquiz.laligastatsquiz.competiciones;

public enum LigaEuropea implements Competicion{

    SANTANDER(1, "La Liga Santander", "https://a.espncdn.com/combiner/i?img=/i/leaguelogos/soccer/500/15.png&transparent=true&w=288&h=288"),
    SMARRBANK(2, "La Liga Smartbank 2", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/LaLiga_SmartBank.svg/1200px-LaLiga_SmartBank.svg.png"),
    PREMIER(3, "Premier League", "https://www.transfermarkt.es/images/logo/originals/gb1.png?lm=1521104656"),
    BUNDESLIGA(6, "Bundesliga", "https://a.espncdn.com/combiner/i?img=/i/leaguelogos/soccer/500/10.png"),
    LIGUE1(7, "Ligue 1", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Ligue1.svg/1200px-Ligue1.svg.png"),
    SERIEA(8, "Serie A", "https://upload.wikimedia.org/wikipedia/commons/9/93/Serie_A_Logo_%28ab_2019%29.png");


    private int id;
    private String name;
    private String urlImage;

    LigaEuropea(int id, String name, String urlImage) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
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
}
