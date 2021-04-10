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
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SportLeagueTests {

    private List<String> resultsInput = new ArrayList<>();

    @BeforeEach
    public void setup() throws IOException, URISyntaxException {
        var path = Paths.get(ClassLoader.getSystemResource("resultsinput.txt").toURI());

        resultsInput = Files.lines(path).collect(Collectors.toList());
    }

    @Test
    void shouldCreateSportLeague() throws StringParseException {
        var league = SportLeague.parse(resultsInput);

        assertEquals(5, league.getMatchesCount());
    }

    @Test
    void shouldCreateLeagueStanding() throws StringParseException {
        var league = SportLeague.parse(resultsInput);

        assertNotNull(league.getLeagueTable());
        assertEquals(5, league.getLeagueTable().getStandings().size());
    }
}
