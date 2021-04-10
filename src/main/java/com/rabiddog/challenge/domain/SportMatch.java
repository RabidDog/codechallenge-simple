package com.rabiddog.challenge.domain;


import com.rabiddog.challenge.exceptions.InvalidStateException;
import lombok.Getter;

@Getter
public class SportMatch {
    private TeamScore teamAScore;
    private TeamScore teamBScore;

    /***
     *
     * @param teamAScore - first team that participated in the match
     * @param teamBScore - second team that participated in the match
     * @return a new instance of SportMatch
     */
    public static SportMatch createInstance(TeamScore teamAScore, TeamScore teamBScore){
        var output = new SportMatch();
        output.teamAScore = teamAScore;
        output.teamBScore = teamBScore;

        return output;
    }

    /***
     *
     * @param matchString - formatted string ("team name score, team name score") eg ("super team 1, other team 0")
     * @return a new instance of SportMatch
     */
    public static SportMatch parse(String matchString) {
        var split = matchString.split(",");
        return SportMatch.createInstance(
                TeamScore.parse(split[0]),
                TeamScore.parse(split[1])
        );
    }

    /***
     *
     * @return instance of the SportMatchResult containing the results of the match
     */
    public SportMatchResult getResult(){
        return SportMatchResult.createInstance(
                teamAScore,
                teamBScore
        );
    }

    /***
     *
     * @return the winner of the match
     * @throws InvalidStateException thrown if the match is a draw/tie
     */
    public TeamScore getWinner() throws InvalidStateException {

        if(getResult().getOutcome() == ResultOutcome.TIE){
           throw new InvalidStateException("The results are a tie");
        }

        return teamAScore.getScore() > teamBScore.getScore() ? teamAScore : teamBScore;
    }

    /***
     *
     * @return the loser of the match
     * @throws InvalidStateException thrown if the match is a draw/tie
     */
    public TeamScore getLoser() throws InvalidStateException {
        if(getResult().getOutcome() == ResultOutcome.TIE){
            throw new InvalidStateException("The results are a tie");
        }

        return teamAScore.getScore() < teamBScore.getScore() ? teamAScore : teamBScore;
    }
}
