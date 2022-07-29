package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in); FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());) {
            int id = Integer.parseInt(args[0]);
            byte[] content = new byte[fileInputStream.available()];
            fileInputStream.read(content);
            String fileString = new String(content);
            Pattern pattern = Pattern.compile("(^"+ (String.valueOf(id)) + ".+?$)", Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(fileString);
            if(matcher.find()) {
                System.out.println(matcher.group(1));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
