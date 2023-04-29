package com.sanjiv.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    /**
     * read a file containing integers. This method creates a new list out of those numbers
     *
     * @param fileName {@link String} name of the file
     * @return {@link List<Integer>} list of integers from input file
     */
    public static List<Integer> getListFromFile(String fileName) {
        List<Integer> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /**
     * write the list of integers to the output file
     *
     * @param fileName {@link String} output file
     * @param list     {@link List<Integer>} list of integers
     */
    public static void writeListToFile(String fileName, List<Integer> list) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            for (Integer integer : list) {
                bufferedWriter.write(integer.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
