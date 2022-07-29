package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader file1 = new BufferedReader(new FileReader(args[0]))
        ) {
            String text = "";
            while (file1.ready()) {
                text += file1.readLine();
            }
            System.out.println(text.replaceAll("[^a-zA-Z]", "").length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
