package com.rabiddog.challenge.domain;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter
public class LeagueStanding {

    private Team team;
    private int points;

    public LeagueStanding(
            @NotNull final Team team,
            final int points){

        Objects.requireNonNull(team, "Team cannot be null");

        this.team = team;
        this.points = points;
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
