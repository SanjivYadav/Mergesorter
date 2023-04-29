package com.sanjiv.services;

import java.util.List;

public class FileReaderService implements Runnable {

    private final String fileName;
    private List<Integer> list;

    public FileReaderService(String fileName) {
        this.fileName = fileName;
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public void run() {
        this.list = FileService.getListFromFile(this.fileName);
    }
}
