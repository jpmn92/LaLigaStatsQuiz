package com.laligastatsquiz.laligastatsquiz.competiciones;

public enum SeleccionesInternacional implements Competicion{

    WC2018(16, "World Cup 2018"),
    WC2014(17, "World Cup 2014"),
    WC2010(18, "World Cup 2010"),
    EURO2016(10, "Euro 1996"),
    EURO2012(11, "Euro 1996"),
    EURO2008(12, "Euro 1996"),
    EURO2004(13, "Euro 1996"),
    EURO2000(14, "Euro 1996"),
    EURO1996(15, "Euro 1996");


    private int id;
    private String name;

    SeleccionesInternacional(int id, String name) {
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
