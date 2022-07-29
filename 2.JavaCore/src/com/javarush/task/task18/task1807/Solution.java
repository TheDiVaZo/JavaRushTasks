package com.javarush.task.task18.task1807;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                FileInputStream input = new FileInputStream(scanner.nextLine())
                ) {
            ArrayList<Integer> byte_list = new ArrayList<>();
            while (input.available() > 0) {
                byte_list.add(input.read());
            }
            System.out.println(byte_list.stream().filter(symbol->symbol.equals(",".hashCode())).count());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
