package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (
                Scanner scanner = new Scanner(System.in);
                FileInputStream file = new FileInputStream(scanner.nextLine());
                ) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            while (file.available() > 0) {
                int value = file.read();
                if(hashMap.containsKey(value)) {
                    hashMap.put(value, hashMap.get(value) + 1);
                }
                else {
                    hashMap.put(value, 1);
                }
            }
             Map.Entry<Integer, Integer> MaxByte = hashMap.entrySet().stream().max((i, j)->i.getValue() - j.getValue()).get();
             List<Map.Entry<Integer, Integer>> MaxBytes = hashMap.entrySet().stream().filter((i)->i.getValue() == MaxByte.getValue()).collect(Collectors.toList());
             String string_bytes = "";
             for(Map.Entry<Integer, Integer> bytes:MaxBytes) {
                 string_bytes += (bytes.getKey() + " ");
             }
             System.out.println(string_bytes.trim());




        }
    }
}
