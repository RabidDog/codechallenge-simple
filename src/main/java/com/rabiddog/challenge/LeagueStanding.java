package com.rabiddog.challenge;

public class LeagueStanding {

    private Team team;
    private int points;
    private int position;

    public static LeagueStanding createInstance(Team team, int points, int position){
        var output = new LeagueStanding();
        output.team = team;
        output.points = points;
        output.position = position;

        return output;
    }

    public Team getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }

    public int getPosition() {
        return position;
    }
}
