package com.rabiddog.challenge.services.readers;

import com.rabiddog.challenge.exceptions.NoFileException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HttpFileReaderServiceTests {
    @Test
    void shouldReadFile() throws IOException, NoFileException {
        var url = "https://raw.githubusercontent.com/RabidDog/codechallenge-simple/main/src/test/resources/resultsinput.txt";

        var reader = FileReaderType.HTTP.getFileReaderService();

        var result = reader.readAllLines(url);

        assertEquals(5, result.size());
    }

    @Test
    void shouldThrowNoFileException() throws IOException, NoFileException {
        var url = "https://raw.githubusercontent.com/RabidDog/codechallenge-simple/main/src/test/resources/resultsinput";

        var reader = FileReaderType.HTTP.getFileReaderService();

        assertThrows(NoFileException.class, () -> reader.readAllLines(url));
    }
}
