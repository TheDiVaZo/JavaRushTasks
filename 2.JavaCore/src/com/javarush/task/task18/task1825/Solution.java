package com.javarush.task.task18.task1825;

import java.io.*;
import java.net.URI;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File outputFile = null;
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedOutputStream outputStream = null;
        TreeSet<String> fileNames = new TreeSet<>();
        while (!fileName.equals("end")) {
            fileNames.add(fileName);
            fileName = scanner.nextLine();
        }
        scanner.close();
        for (String name : fileNames) {
            if(outputFile == null) {
                outputFile = new File(new File(name).getParentFile().getPath()+"\\Lion.avi");
                outputFile.createNewFile();
            }
            if(outputStream == null) {
                outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
            }
            try(FileInputStream fileInputStream = new FileInputStream(name)) {
                byte[] content = new byte[fileInputStream.available()];
                fileInputStream.read(content);
                outputStream.write(content);
            }
        }
        if(outputStream != null) {
            outputStream.flush();
            outputStream.close();
        }
    }
}
