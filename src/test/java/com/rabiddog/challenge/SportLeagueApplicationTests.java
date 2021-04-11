package com.rabiddog.challenge;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SportLeagueApplicationTests {

    @Test
    void shouldReadInputFromLocalFile() throws URISyntaxException {

        var path = Paths.get(ClassLoader.getSystemResource("resultsinput.txt").toURI());
        String[] args = {path.toString()};

        assertDoesNotThrow(() -> SportLeagueApplication.main(args));
    }

    @Test
    void shouldReadInputFromHttpSourceFile() {

        String[] args = {"https://raw.githubusercontent.com/RabidDog/codechallenge-simple/main/src/test/resources/resultsinput.txt"};

        assertDoesNotThrow(() -> SportLeagueApplication.main(args));
    }
}
