package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in);
                BufferedWriter buffer = new BufferedWriter(new FileWriter(scanner.nextLine()));
                )
        {
            while (true) {
                String line = scanner.nextLine();
                if(line.equalsIgnoreCase("exit")) {
                    buffer.write("exit");
                    break;
                }
                buffer.write(line + "\n");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
