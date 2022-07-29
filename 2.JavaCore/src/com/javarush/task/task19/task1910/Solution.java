package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader file1 = new BufferedReader(new FileReader(scanner.readLine()));
            BufferedWriter file2 = new BufferedWriter(new FileWriter(scanner.readLine()));
            ) {
            while (file1.ready()) {
                file2.write(file1.readLine().replaceAll("[^a-zA-ZА-Яа-я0-9\\s]", ""));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
