package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            String word = string.substring(string.indexOf(' ')+1);
            return String.format("%s %s %s %s", word.split(" "));
        } catch (Throwable e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
