package com.laligastatsquiz.laligastatsquiz.competiciones;

public enum ClubesInternacional implements Competicion{
    CHAMPIONS(9, "UEFA Champions League", "https://upload.wikimedia.org/wikipedia/en/thumb/b/bf/UEFA_Champions_League_logo_2.svg/1200px-UEFA_Champions_League_logo_2.svg.png"),
    UEFA(20, "UEFA Europa League", "https://as01.epimg.net/img/comunes/logos/competiciones/futbol-europa_league.png"),
    UCLUEL(0, "UCL + UEL", "https://betting-preview.com/wp-content/uploads/2020/01/cl-el.png");

    private int id;
    private String name;
    private String urlImage;
    private int country;
    private int tipo;

    ClubesInternacional(int id, String name, String urlImage) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
        this.tipo = 2;

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
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    @Override
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
