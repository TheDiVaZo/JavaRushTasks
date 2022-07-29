package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            try (FileInputStream stream = new FileInputStream(fileName);) {

            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                scanner.close();
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
