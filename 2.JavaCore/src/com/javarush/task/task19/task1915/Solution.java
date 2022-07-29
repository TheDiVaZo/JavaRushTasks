package com.javarush.task.task19.task1915;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try (
                BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
                FileOutputStream file1 = new FileOutputStream(scanner.readLine());
                ) {
            PrintStream consoleOut = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(outputStream);
            System.setOut(stream);

            testString.printSomething();

            String result = outputStream.toString();

            file1.write(result.getBytes(StandardCharsets.UTF_8));
            System.setOut(consoleOut);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

