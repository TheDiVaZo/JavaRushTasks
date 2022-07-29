package com.javarush.task.pro.task15.task1506;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
        ) {
            List<String> strings = Files.readAllLines(Paths.get(scanner.nextLine()));
            strings.forEach(str->{
                char[] chars = str.toCharArray();
                for(int i = 0; i < chars.length;i++) {
                    Character char_str = chars[i];
                    if(!char_str.equals(' ') && !char_str.equals(',') && !char_str.equals('.')) {
                        System.out.print(char_str);
                    }
                }
                System.out.println();
            });
        }
        catch (Throwable e) {
            return;
        }
    }
}

