package com.rabiddog.challenge.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportMatchParserTests {

    private final String matchString = "Lions 3, Snakes 2";

    @Test
    void shouldParseSportMatch(){
        var sportMatch = SportMatch.parse(matchString);

        assertNotNull(sportMatch.getTeamAScore());
        assertNotNull(sportMatch.getTeamBScore());

        assertEquals("Lions", sportMatch.getTeamAScore().getTeam().getName());
        assertEquals(3, sportMatch.getTeamAScore().getScore());

        assertEquals("Snakes", sportMatch.getTeamBScore().getTeam().getName());
        assertEquals(2, sportMatch.getTeamBScore().getScore());
    }


}
