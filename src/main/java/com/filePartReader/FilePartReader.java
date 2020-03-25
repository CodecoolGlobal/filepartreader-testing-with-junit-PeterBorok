package com.filePartReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FilePartReader {
    String filePath = "x";
    Integer fromLine;
    Integer toLine;


    public FilePartReader() {
        this.filePath = "x";
        this.fromLine = -2;
        this.toLine = -1;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
    }

    public String read() throws IOException {
        String data = Files.readString(Paths.get(filePath));
        return data;
    }

    public String readlines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        String resultString = "";

        for (int i = 0; i < lines; i++) {
            if (fromLine-1 <= i && i < toLine) {
                resultString += Files.readAllLines(Paths.get(filePath)).get(i);
            }
        }

        return resultString;
    }
}
