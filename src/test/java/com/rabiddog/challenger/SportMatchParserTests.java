package com.rabiddog.challenger;

import com.rabiddog.challenge.SportMatch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SportMatchParserTests {

    private final String matchString = "Lions 3, Snakes 2";

    @Test
    public void shouldParseSportMatch(){
        var sportMatch = SportMatch.parse(matchString);

        assertTrue(sportMatch.getTeamAScore() != null);
        assertTrue(sportMatch.getTeamBScore() != null);

        assertEquals("Lions", sportMatch.getTeamAScore().getTeam().getName());
        assertEquals(3, sportMatch.getTeamAScore().getScore());

        assertEquals("Snakes", sportMatch.getTeamBScore().getTeam().getName());
        assertEquals(2, sportMatch.getTeamBScore().getScore());
    }


}
