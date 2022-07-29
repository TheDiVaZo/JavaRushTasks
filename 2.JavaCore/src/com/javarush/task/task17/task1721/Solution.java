package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                BufferedReader file1 = new BufferedReader(new FileReader(scanner.nextLine()));
                BufferedReader file2 = new BufferedReader(new FileReader(scanner.nextLine()))
        ) {
            while (file1.ready()) {
                allLines.add(file1.readLine());
            }
            while (file2.ready()) {
                forRemoveLines.add(file2.readLine());
            }
            new Solution().joinData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void joinData() throws CorruptedDataException {
        List<String> lines = allLines.stream().filter(line->forRemoveLines.contains(line)).collect(Collectors.toList());
        if(lines.size() != forRemoveLines.size()) {
            allLines.clear();
            throw new CorruptedDataException();
        }
        else {
            allLines.removeAll(lines);
        }

    }
}
