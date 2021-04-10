package com.rabiddog.challenge;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SportLeagueApplicationTests {

    @Test
    void shouldReadInputFile() throws URISyntaxException {
        var path = Paths.get(ClassLoader.getSystemResource("resultsinput.txt").toURI());
        String[] args = {path.toString()};

        SportLeagueApplication.main(args);
        assertTrue(true);
    }
}
