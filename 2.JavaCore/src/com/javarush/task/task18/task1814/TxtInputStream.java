package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {


    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String[]  arr_file = Paths.get(fileName).getFileName().toString().split("\\.");
        if(!arr_file[arr_file.length-1].equals("txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws UnsupportedFileNameException, IOException {
    }
}

