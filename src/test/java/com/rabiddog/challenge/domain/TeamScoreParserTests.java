package com.rabiddog.challenge.domain;

import com.rabiddog.challenge.exceptions.StringParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamScoreParserTests {

    private final String teamScoreString = "FC Lions 3";
    private final String teamScoreStringWeakFormat = " Lions  3 ";

    @Test
    void shouldParseTeamScore() throws StringParseException {
        var teamScore = TeamScore.parse(teamScoreString);

        assertEquals("FC Lions", teamScore.getTeam().getName());
        assertEquals(3, teamScore.getScore());
    }

    @Test
    void shouldParseTeamScoreWeakString() throws StringParseException {
        var teamScore = TeamScore.parse(teamScoreStringWeakFormat);

        assertEquals("Lions", teamScore.getTeam().getName());
        assertEquals(3, teamScore.getScore());
    }
}
