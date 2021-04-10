package com.rabiddog.challenge.domain;

import lombok.Getter;

@Getter
public class LeagueStanding {

    private Team team;
    private int points;

    /***
     *
     * @param team - the team that the standing is for
     * @param points- the number of points the team has
     * @return - new instance of LeagueStanding
     */
    public static LeagueStanding createInstance(Team team, int points){
        var output = new LeagueStanding();
        output.team = team;
        output.points = points;

        return output;
    }

    /***
     *
     * @return formatted string of the team name and the number of points they have
     */
    public String printStanding(){
        return String.format("%s, %s %s", this.team.getName(), this.points, this.getPointsString());
    }

    /***
     *
     * @param pointsToAdd - the number of points to add to the team standing
     */
    public void addPoints(int pointsToAdd) {
        this.points = this.points + pointsToAdd;
    }

    private String getPointsString(){
        return this.points == 1 ? "pt" :  "pts";
    }
}
