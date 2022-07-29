package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (
                Scanner scanner = new Scanner(System.in);
                FileInputStream file = new FileInputStream(scanner.nextLine());
        ) {
            ArrayList<Integer> bytes = new ArrayList<>();
            while (file.available() > 0) {
                bytes.add(file.read());
            }
            System.out.println((byte) IntStream.of(bytes.stream().mapToInt(i->i).toArray()).max().getAsInt());

        }
    }
}
