package com.rabiddog.challenge.domain;

public class SportMatchResult {
    private TeamScore teamAScore;
    private TeamScore teamBScore;

    public static SportMatchResult createInstance(TeamScore teamAScore, TeamScore teamBScore) {
        var output = new SportMatchResult();
        output.teamAScore = teamAScore;
        output.teamBScore = teamBScore;

        return output;
    }

    public ResultOutcome getOutcome(){
        if (teamAScore.getScore() == teamBScore.getScore()){
            return ResultOutcome.TIE;
        } else {
            return ResultOutcome.DECISIVE;
        }
    }
}
