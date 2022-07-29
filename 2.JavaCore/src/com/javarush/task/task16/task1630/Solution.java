package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try (Scanner scanner = new Scanner(System.in)) {
            firstFileName = scanner.nextLine();
            secondFileName = scanner.nextLine();


        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface  {

        String fullFileName;

        String fileContent = "";

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return  fileContent;
        }

        @Override
        public void run() {
            super.run();
            String lines = "";
            try (BufferedReader ReaderFile = new BufferedReader(new FileReader(fullFileName))) {
                while (true) {
                    String line = ReaderFile.readLine();
                    if(line != null) {
                        lines += (" "+line);
                    }
                    else break;
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileContent = lines.trim();

        }
    }
}
