package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                BufferedReader file1 = new BufferedReader(new FileReader(scanner.nextLine()));
                BufferedWriter file2 = new BufferedWriter(new FileWriter(scanner.nextLine()))
                ) {
            ArrayList<Integer> doubleList = new ArrayList<>();
            while (file1.ready()) {
                for(double number: Arrays.stream(file1.readLine().split(" ")).flatMapToDouble((x)-> DoubleStream.of(Double.parseDouble(x))).toArray()) {
                    doubleList.add((int) Math.round(number));
                }
            }
            ArrayList<String> strList = new ArrayList<>();
            doubleList.forEach(x->strList.add(x.toString()));
            file2.write(String.join(" ", strList));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
