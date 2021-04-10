package com.rabiddog.challenger;

import com.rabiddog.challenge.TeamScore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeamScoreParserTests {

    private final String teamScoreString = "Lions 3";
    private final String teamScoreStringWeakFormat = " Lions  3 ";

    @Test
    public void shouldParseTeamScore(){
        var teamScore = TeamScore.parse(teamScoreString);

        assertEquals("Lions", teamScore.getTeam().getName());
        assertEquals(3, teamScore.getScore());
    }

    @Test
    public void shouldNotParseTeamScore(){
        var teamScore = TeamScore.parse(teamScoreStringWeakFormat);

        assertEquals("Lions", teamScore.getTeam().getName());
        assertEquals(3, teamScore.getScore());
    }

    // Handle parse exception
}
