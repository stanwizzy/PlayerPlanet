package com.playerplanet.core.model;


import java.util.List;

public class Team {

    private League league;
    private String name;
    private List<Player> players;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public League getLeague() {

        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
