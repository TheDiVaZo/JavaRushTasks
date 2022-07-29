package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
                FileReader file = new FileReader(scanner.readLine())
                ) {
            String words_str = "";
            while (file.ready()) {
                Character let = (char) file.read();
                if(let.equals('\n')) let = ' ';
                words_str += let.toString();
            }
            List<String> words = Arrays.asList(words_str.replaceAll("[^A-Za-zА-Яа-я0-9]", " ").split(" "));
            System.out.println(words.stream().filter((word)->word.equals("world")).count());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
