package com.rabiddog.challenge.services.readers;

public enum FileReaderType {

    LOCAL(new LocalFileReaderService()),
    HTTP(new HttpFileReaderService());

    private FileReaderService fileReaderService;

    FileReaderType(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public FileReaderService getFileReaderService() {
        return this.fileReaderService;
    }
}
