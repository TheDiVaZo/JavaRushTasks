package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (
                Scanner scanner = new Scanner(System.in);
                FileInputStream file = new FileInputStream(scanner.nextLine());
        ) {
            ArrayList<Integer> list_byte = new ArrayList<>();
            while (file.available() > 0) {
                list_byte.add(file.read());
            }
            Set<Integer> set_bytes = new HashSet<Integer>(list_byte);
            String byte_codes = "";
            Iterator<Integer> iterator = set_bytes.iterator();
            while (iterator.hasNext()) {
                byte_codes += iterator.next().intValue() + " ";
            }
            System.out.println(byte_codes.trim());
        }
    }
}
