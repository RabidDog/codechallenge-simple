package com.rabiddog.challenge.domain;

import lombok.Getter;

@Getter
public class LeagueStanding {

    private Team team;
    private int points;

    public static LeagueStanding createInstance(Team team, int points){
        var output = new LeagueStanding();
        output.team = team;
        output.points = points;

        return output;
    }

    public Team getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int pointsToAdd) {
        this.points = this.points + pointsToAdd;
    }

    public String printStanding(){
        return String.format("%s, %s %s", this.team.getName(), this.points, this.getPointsString());
    }

    private String getPointsString(){
        return this.points == 1 ? "pt" :  "pts";
    }
}
