package com.rabiddog.challenge.domain;


import com.rabiddog.challenge.exceptions.InvalidStateException;

public class SportMatch {
    private TeamScore teamAScore;
    private TeamScore teamBScore;

    public static SportMatch createInstance(TeamScore teamAScore, TeamScore teamBScore){
        var output = new SportMatch();
        output.teamAScore = teamAScore;
        output.teamBScore = teamBScore;

        return output;
    }

    public static SportMatch parse(String matchString) {
        var split = matchString.split(",");
        return SportMatch.createInstance(
                TeamScore.parse(split[0]),
                TeamScore.parse(split[1])
        );
    }

    public TeamScore getTeamAScore(){
        return this.teamAScore;
    }

    public TeamScore getTeamBScore(){
        return this.teamBScore;
    }

    public SportMatchResult getResult(){
        return SportMatchResult.createInstance(
                teamAScore,
                teamBScore
        );
    }

    public TeamScore getWinner() throws InvalidStateException {

        if(getResult().getOutcome() == ResultOutcome.TIE){
           throw new InvalidStateException("The results are a tie");
        }

        return teamAScore.getScore() > teamBScore.getScore() ? teamAScore : teamBScore;
    }

    public TeamScore getLoser() throws InvalidStateException {
        if(getResult().getOutcome() == ResultOutcome.TIE){
            throw new InvalidStateException("The results are a tie");
        }

        return teamAScore.getScore() < teamBScore.getScore() ? teamAScore : teamBScore;
    }
}
