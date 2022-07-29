package com.javarush.task.pro.task15.task1514;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Все относительно
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path str1 = Path.of(scanner.nextLine());
        Path str2 = Path.of(scanner.nextLine());
        try {
            System.out.println(str1.relativize(str2));
        }
        catch (Throwable e) {
            return;
        }
    }
}

