package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                Scanner inputFile = new Scanner(new FileInputStream(scanner.nextLine()));
                ) {
            ArrayList<Integer> numbers = new ArrayList<>();
            while (inputFile.hasNext()) {
                numbers.add(Integer.parseInt(inputFile.nextLine().trim()));
            }
            numbers.stream().filter(x->x%2==0).sorted().forEach(System.out::println);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
