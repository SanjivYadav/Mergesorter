package com.sanjiv.services;

import java.io.File;
import java.io.FilenameFilter;

public class InputFileNameFilter implements FilenameFilter {

    private static InputFileNameFilter instance = null;

    private InputFileNameFilter() {

    }

    public static InputFileNameFilter getInstance() {
        if (instance == null) {
            synchronized (InputFileNameFilter.class) {
                // double check locking
                if (instance == null) {
                    instance = new InputFileNameFilter();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.startsWith("in") && name.endsWith(".txt");
    }
}
