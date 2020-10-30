package com.laligastatsquiz.laligastatsquiz.competiciones;

public enum ClubesInternacional implements Competicion{

    CHAMPIONS(9, "UEFA Champions League");

    private int id;
    private String name;

    ClubesInternacional(int id, String name) {
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
