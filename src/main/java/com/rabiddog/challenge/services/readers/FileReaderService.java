package com.rabiddog.challenge.services.readers;

import com.rabiddog.challenge.exceptions.NoFileException;

import java.io.IOException;
import java.util.List;

public interface FileReaderService {

    List<String> readAllLines(String path) throws IOException, NoFileException;

}
