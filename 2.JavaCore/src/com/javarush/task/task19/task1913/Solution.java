package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream original_out = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);


        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString().replaceAll("[^0-9]", "");
        System.setOut(original_out);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
