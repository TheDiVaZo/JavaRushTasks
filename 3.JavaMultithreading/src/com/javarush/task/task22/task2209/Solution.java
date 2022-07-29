package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
        scanner.close();
        String words = "";
        while (reader.ready()) {
            words += reader.readLine();
        }
        StringBuilder result = getLine(words.split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder resultString = new StringBuilder();
        List<String> worldsArrayList = new ArrayList<>();
        Collections.addAll(worldsArrayList, Arrays.copyOf(words, words.length));
        do {
            for(int i = 0; i < worldsArrayList.size(); i++) {
                String word = worldsArrayList.get(i);
                if(resultString.length()==0) {
                    resultString.append(word);
                    worldsArrayList.remove(i);
                    break;
                }
                else if(resultString.toString().toLowerCase(Locale.ROOT).charAt(resultString.length()-1)==word.toLowerCase(Locale.ROOT).charAt(0)) {
                    resultString.append(" " + word);
                    worldsArrayList.remove(i);
                    break;
                }
                else if(resultString.toString().toLowerCase(Locale.ROOT).charAt(0)==word.toLowerCase(Locale.ROOT).charAt(word.length()-1)) {
                    resultString = new StringBuilder(word + " " + resultString);
                    worldsArrayList.remove(i);
                    break;
                }

            }
        }
        while (worldsArrayList.size()!=0);
        return resultString;
    }
}
