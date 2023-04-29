package com.sanjiv.services;

import java.util.List;

public class FileWriterService implements Runnable {

    private final String fileName;
    private final List<Integer> data;

    public FileWriterService(String fileName, List<Integer> data) {
        this.fileName = fileName;
        this.data = data;
    }

    @Override
    public void run() {
        FileService.writeListToFile(fileName, data);
    }
}
