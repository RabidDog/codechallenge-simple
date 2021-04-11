package com.rabiddog.challenge.services.readers;

import com.rabiddog.challenge.exceptions.NoFileException;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HttpFileReaderService implements FileReaderService {

    @Override
    public List<String> readAllLines(
            @NotNull final String path) throws IOException, NoFileException {

        Objects.requireNonNull(path, "The path cannot be null");

        var resultList = new ArrayList<String>();

        var url = new URL(path);

        try (var reader = new BufferedReader(
                new InputStreamReader(url.openStream()))) {

            String line;

            while ((line = reader.readLine()) != null) {
                resultList.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new NoFileException(e.getMessage());
        }


        return resultList;
    }
}
