package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String fileName = scanner.nextLine();
            while (!"exit".equals(fileName)) {
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
                fileName = scanner.nextLine();
            }
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public synchronized void start() {
            super.start();
            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                byte[] context = new byte[fileInputStream.available()];
                fileInputStream.read(context);
                int[] countBytes = new int[256];
                for (byte b : context) {
                    countBytes[Byte.toUnsignedInt(b)]++;
                }
                byte maxByte = 0;
                for (int i = 0; i < countBytes.length; i++) {
                    if(countBytes[Byte.toUnsignedInt(maxByte)] < countBytes[i]) {
                        maxByte = (byte) i;
                    }
                }
                resultMap.put(fileName, (int) maxByte);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
