package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                BufferedWriter file1 = new BufferedWriter(new FileWriter(scanner.nextLine()));
                BufferedReader file2 = new BufferedReader(new FileReader(scanner.nextLine()));
                BufferedReader file3 = new BufferedReader(new FileReader(scanner.nextLine()));
                ) {
            while (file2.ready()) {
                file1.write(file2.readLine());
            }
            while (file3.ready()) {
                file1.write(file3.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
