package com.rabiddog.challenge.domain;


import com.rabiddog.challenge.exceptions.InvalidStateException;
import com.rabiddog.challenge.exceptions.StringParseException;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Getter
public class SportMatch {

    private TeamScore teamAScore;
    private TeamScore teamBScore;

    public SportMatch(
            @NotNull final TeamScore teamAScore,
            @NotNull final TeamScore teamBScore) {

        Objects.requireNonNull(teamAScore, "Team A Score cannot be null");
        Objects.requireNonNull(teamBScore, "Team B Score cannot be null");

        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
    }

    /***
     *
     * @param matchString - formatted string ("team name score, team name score") eg ("super team 1, other team 0")
     * @return a new instance of SportMatch
     */
    public static SportMatch parse(
            @NotNull final String matchString) throws StringParseException {

        Objects.requireNonNull(matchString, "Match String cannot be null");

        var split = matchString.split(",");

        if (split.length != 2) {
            throw new StringParseException("The match provided must contain two teams and two scores");
        }

        return new SportMatch(
                TeamScore.parse(split[0]),
                TeamScore.parse(split[1]));
    }

    /***
     *
     * @return instance of the SportMatchResult containing the results of the match
     */
    public SportMatchResult getResult() {
        return new SportMatchResult(
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

        if (getResult().getOutcome() == ResultOutcome.TIE) {
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
        if (getResult().getOutcome() == ResultOutcome.TIE) {
            throw new InvalidStateException("The results are a tie");
        }

        return teamAScore.getScore() < teamBScore.getScore() ? teamAScore : teamBScore;
    }
}
