package com.rabiddog.challenge.domain;

import com.rabiddog.challenge.exceptions.StringParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeagueTableTests {

    private List<SportMatch> matches = new ArrayList<>();

    @BeforeEach
    public void setup() throws IOException, URISyntaxException {

        var path = Paths.get(ClassLoader.getSystemResource("resultsinput.txt").toURI());

        Files.lines(path).forEach(match -> {
            try {
                matches.add(SportMatch.parse(match));
            } catch (StringParseException e) {
                e.printStackTrace();
            }
        });


    }
    @Test
    void shouldListLeagueStandingsByPoints(){

        var league = new LeagueTable(matches);

        var orderedStandings = league.getSortedLeagueStandings();

        assertEquals(6, orderedStandings.get(0).getPoints());
        assertEquals("Tarantulas", orderedStandings.get(0).getTeam().getName());

        assertEquals(5, orderedStandings.get(1).getPoints());
        assertEquals("Lions", orderedStandings.get(1).getTeam().getName());

        assertEquals(1, orderedStandings.get(2).getPoints());
        assertEquals("FC Awesome", orderedStandings.get(2).getTeam().getName());

        assertEquals(1, orderedStandings.get(3).getPoints());
        assertEquals("Snakes", orderedStandings.get(3).getTeam().getName());

        assertEquals(0, orderedStandings.get(4).getPoints());
        assertEquals("Grouches", orderedStandings.get(4).getTeam().getName());
    }

    @Test
    void shouldFormatLeagueStandingStringForPrint(){

        var league = new LeagueTable(matches);
        var orderedStandings = league.getSortedLeagueStandings();

        assertEquals("Tarantulas, 6 pts", orderedStandings.get(0).printStanding());
        assertEquals("Lions, 5 pts", orderedStandings.get(1).printStanding());
        assertEquals("FC Awesome, 1 pt", orderedStandings.get(2).printStanding());
        assertEquals("Snakes, 1 pt", orderedStandings.get(3).printStanding());
        assertEquals("Grouches, 0 pts", orderedStandings.get(4).printStanding());
    }
}
