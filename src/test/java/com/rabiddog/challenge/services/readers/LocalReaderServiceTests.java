package com.rabiddog.challenge.services.readers;

import com.rabiddog.challenge.exceptions.NoFileException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocalReaderServiceTests {

    @Test
    void shouldReadFile() throws URISyntaxException, IOException, NoFileException {
        var path = Paths.get(ClassLoader.getSystemResource("resultsinput.txt").toURI());

        var reader = FileReaderType.LOCAL.getFileReaderService();

        var results = reader.readAllLines(path.toAbsolutePath().toString());

        assertEquals(5, results.size());
    }

    @Test
    void shouldThrowNoFileException() throws URISyntaxException {
        var path = "/invalid/path";

        var reader = FileReaderType.LOCAL.getFileReaderService();

        assertThrows(NoFileException.class, () -> reader.readAllLines(path));
    }
}
