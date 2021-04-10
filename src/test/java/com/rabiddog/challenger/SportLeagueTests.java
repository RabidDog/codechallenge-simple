package com.rabiddog.challenger;

import com.rabiddog.challenge.SportLeague;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SportLeagueTests {

    private final List<String> resultsInput = new ArrayList<>();

    @Before
    public void setup() throws IOException {
        var inputStream = getClass().getClassLoader().getResourceAsStream("resultsinput.txt");
        var reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";

        while ((line = reader.readLine()) != null) {
            resultsInput.add(line);
        }
    }

    @Test
    public void shouldCreateSportLeague(){
        var league = SportLeague.parse(resultsInput);

        assertEquals(5, league.getMatchesCount());
    }
}
