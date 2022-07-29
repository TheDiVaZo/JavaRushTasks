package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (
                Scanner scanner = new Scanner(System.in);
                FileInputStream file = new FileInputStream(scanner.nextLine())
                ) {
            ArrayList<Integer> list = new ArrayList<>();
            while (file.available()>0) {
                list.add(file.read());
            }
            System.out.println((byte)IntStream.of(list.stream().mapToInt(i->i).toArray()).min().getAsInt());

        }
    }
}
