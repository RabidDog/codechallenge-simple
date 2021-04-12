package com.rabiddog.challenge;

import com.rabiddog.challenge.domain.SportLeague;
import com.rabiddog.challenge.exceptions.NoFileException;
import com.rabiddog.challenge.exceptions.StringParseException;
import com.rabiddog.challenge.services.ConsolePrintService;
import com.rabiddog.challenge.services.readers.FileReaderService;
import com.rabiddog.challenge.services.readers.FileReaderType;

import java.io.IOException;


public class SportLeagueApplication {

    public static void main(String... args) {
        if (args.length != 1) {
            System.err.println("Please provide a path to the results file");
            return;
        }

        FileReaderService fileReaderService;

        var fileLocation = args[0];

        if (fileLocation.startsWith("http")) {
            fileReaderService = FileReaderType.HTTP.getFileReaderService();
        } else {
            fileReaderService = FileReaderType.LOCAL.getFileReaderService();
        }

        try {
            SportLeague.parse(fileReaderService.readAllLines(fileLocation))
                    .getLeagueTable()
                    .printLeagueStandings(System.out);
            System.out.println();
        } catch (IOException e) {
            ConsolePrintService.printError(String.format("There was a problem reading the file from the path %s", fileLocation));
            ConsolePrintService.printNestedError(e);
            e.printStackTrace();
        } catch (StringParseException e) {
            ConsolePrintService.printError(String.format("There is an error with data inside file from the path %s", fileLocation));
            ConsolePrintService.printNestedError(e);
        } catch (NoFileException e) {
            ConsolePrintService.printError(
                    String.format("There is no file located at '%s'%n", fileLocation)
            );
        }
    }
}
