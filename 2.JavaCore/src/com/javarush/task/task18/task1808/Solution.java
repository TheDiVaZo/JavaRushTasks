package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                FileInputStream file1 = new FileInputStream(scanner.nextLine());
                FileOutputStream file2 = new FileOutputStream(scanner.nextLine());
                FileOutputStream file3 = new FileOutputStream(scanner.nextLine());
                ) {
            int size_file = (int)  Math.ceil(file1.available() / 2);
            while (file1.available() - size_file > 0) {
                file2.write(file1.read());
            }
            while (file1.available() > 0) {
                file3.write(file1.read());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
