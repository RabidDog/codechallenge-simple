package com.rabiddog.challenge.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TeamTests {

    @Test
    void shouldBeEqual() {
        var team1 = new Team("Team 1");
        var team2 = new Team("Team 1");

        assertEquals(team1, team2);
    }

    @Test
    void shouldReturnName() {
        var teamName = "Team";
        var team = new Team(teamName);

        assertEquals(teamName, team.toString());
    }

    @Test
    void shouldReturnHashCode() {
        var team = new Team("Team");

        assertTrue(team.hashCode() > 0);
    }
}
