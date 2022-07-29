package com.javarush.task.pro.task15.task1512;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* 
Задом наперед
*/

public class Solution {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        String result = new StringBuffer(outputStream.toString()).reverse().toString();
        outputStream.reset();
        outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        System.out.println(outputStream.toString());

    }

    public static void printSomething(String str) {
        stream.print(str);
    }
}