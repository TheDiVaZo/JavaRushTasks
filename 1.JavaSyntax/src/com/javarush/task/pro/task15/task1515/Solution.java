package com.javarush.task.pro.task15.task1515;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Абсолютный путь
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path path = Path.of(scanner.nextLine());
        if(!path.isAbsolute()) {
            path = path.toAbsolutePath();
        }
        System.out.println(path);
    }
}

