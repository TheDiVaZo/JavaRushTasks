package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                FileInputStream file1 = new FileInputStream(scanner.nextLine());
                FileOutputStream file2 = new FileOutputStream(scanner.nextLine());
                ) {
            ArrayList<Integer> byte_list = new ArrayList<>();
            while (file1.available() > 0) {
                byte_list.add(file1.read());
            }
            Collections.reverse(byte_list);
            for(int bytes:byte_list) {
                file2.write(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
