package com.rabiddog.challenge.services.readers;

import com.rabiddog.challenge.exceptions.NoFileException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LocalFileReaderService implements FileReaderService {

    @Override
    public List<String> readAllLines(
            @NotNull final String inputPath) throws IOException, NoFileException {

        Objects.requireNonNull(inputPath, "The input path cannot be null");

        var path = Path.of(inputPath);

        if (!Files.exists(path)) {
            throw new NoFileException(
                    String.format("There is no file located at %s", inputPath)
            );
        }

        try(var lines = Files.lines(path)){
            return lines.collect(Collectors.toList());
        }
    }
}
