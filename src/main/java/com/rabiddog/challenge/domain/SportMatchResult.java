package com.rabiddog.challenge.domain;

public class SportMatchResult {
    private TeamScore teamAScore;
    private TeamScore teamBScore;

    /***
     *
     * @param teamAScore first team that participated in the match
     * @param teamBScore second team that participated in the match
     * @return a new instance of SportMatchResult
     */
    public static SportMatchResult createInstance(TeamScore teamAScore, TeamScore teamBScore) {
        var output = new SportMatchResult();
        output.teamAScore = teamAScore;
        output.teamBScore = teamBScore;

        return output;
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
