package com.rabiddog.challenge.domain;

import com.rabiddog.challenge.exceptions.InvalidStateException;
import com.rabiddog.challenge.exceptions.StringParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportMatchTests {

    private final String matchString = "Lions 3, Snakes 2";

    @Test
    void shouldParseSportMatch() throws StringParseException {

        var sportMatch = SportMatch.parse(matchString);

        assertNotNull(sportMatch.getTeamAScore());
        assertNotNull(sportMatch.getTeamBScore());

        assertEquals("Lions", sportMatch.getTeamAScore().getTeam().getName());
        assertEquals(3, sportMatch.getTeamAScore().getScore());

        assertEquals("Snakes", sportMatch.getTeamBScore().getTeam().getName());
        assertEquals(2, sportMatch.getTeamBScore().getScore());
    }

    @Test
    void shouldThrowInvalidStateException() {
        var teamAScore = new TeamScore(
                new Team("Team 1"),
                2
        );

        var teamBScore = new TeamScore(
                new Team("Team 2"),
                2
        );

        var sportMatch = new SportMatch(teamAScore, teamBScore);

        assertThrows(InvalidStateException.class, () -> sportMatch.getWinner());
        assertThrows(InvalidStateException.class, () -> sportMatch.getLoser());
    }

    @Test
    void shouldThrowStringParseException() {
        var invalidInput = "Team A 3";

        assertThrows(StringParseException.class, () -> SportMatch.parse(invalidInput));
    }


}
