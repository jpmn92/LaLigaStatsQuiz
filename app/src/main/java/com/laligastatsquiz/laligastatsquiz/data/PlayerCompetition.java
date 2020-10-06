package com.laligastatsquiz.laligastatsquiz.data;

public class PlayerCompetition {

    private String name;
    private String lastName;
    private String urlPlayerPhoto;
    private String urlTeamPhoto;
    private int goals;
    private int assists;
    private String teamName;
    private String competitionName;
    private String season;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUrlPlayerPhoto() {
        return urlPlayerPhoto;
    }

    public void setUrlPlayerPhoto(String urlPlayerPhoto) {
        this.urlPlayerPhoto = urlPlayerPhoto;
    }

    public String getUrlTeamPhoto() {
        return urlTeamPhoto;
    }

    public void setUrlTeamPhoto(String urlTeamPhoto) {
        this.urlTeamPhoto = urlTeamPhoto;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

}