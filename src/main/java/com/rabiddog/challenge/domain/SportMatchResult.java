package com.rabiddog.challenge.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SportMatchResult {
    private TeamScore teamAScore;
    private TeamScore teamBScore;

    public SportMatchResult(
            @NotNull final TeamScore teamAScore,
            @NotNull final TeamScore teamBScore) {

        Objects.requireNonNull(teamAScore, "Team A Score cannot be null");
        Objects.requireNonNull(teamBScore, "Team B Score cannot be null");

        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
    }

    /***
     *
     * @return the outcome of the match.
     */
    public ResultOutcome getOutcome(){
        if (teamAScore.getScore() == teamBScore.getScore()){
            return ResultOutcome.TIE;
        } else {
            return ResultOutcome.DECISIVE;
        }
    }
}
