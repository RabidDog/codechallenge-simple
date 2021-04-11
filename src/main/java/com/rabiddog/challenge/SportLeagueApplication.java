package com.rabiddog.challenge;

import com.rabiddog.challenge.domain.SportLeague;
import com.rabiddog.challenge.exceptions.StringParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


public class SportLeagueApplication {

    public static void main(String... args) {
        if (args.length != 1) {
            System.err.println("Please provide a path to the results file");
            return;
        }

        var path = Paths.get(args[0]);

        if (!Files.exists(path)) {
            System.err.println("The provided file does not exist - please check the path");
            return;
        }

        try (var lines = Files.lines(path)) {
            SportLeague.parse(lines.collect(Collectors.toList()))
                    .getLeagueTable()
                    .printLeagueStandings(System.out);
            System.out.println();
        } catch (IOException e) {
            System.err.printf("There was a problem reading the file from the path %s", args[0]);
            System.err.println();
        } catch (StringParseException e) {
            System.err.printf("There is an error in the data inside file from the path %s", args[0]);
            System.err.println();
            System.err.printf("Nested error is '%s'", e.getMessage());
            System.err.println();
        }
    }
}
