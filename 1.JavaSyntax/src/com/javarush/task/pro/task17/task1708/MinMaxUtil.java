package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.util.Arrays;

public class MinMaxUtil {
    public static int max(int a, int b) {
        int[] arr = {a, b};
        return Arrays.stream(arr).max().getAsInt();
    }
    public static int max(int a, int b, int c) {
        int[] arr = {a, b, c};
        return Arrays.stream(arr).max().getAsInt();
    }
    public static int max(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        return Arrays.stream(arr).max().getAsInt();
    }
    public static int max(int a, int b, int c, int d, int e) {
        int[] arr = {a, b, c, d, e};
        return Arrays.stream(arr).max().getAsInt();
    }
    public static int min(int a, int b) {
        int[] arr = {a, b};
        return Arrays.stream(arr).min().getAsInt();
    }
    public static int min(int a, int b, int c) {
        int[] arr = {a, b, c};
        return Arrays.stream(arr).min().getAsInt();
    }
    public static int min(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        return Arrays.stream(arr).min().getAsInt();
    }
    public static int min(int a, int b, int c, int d, int e) {
        int[] arr = {a, b, c, d, e};
        return Arrays.stream(arr).min().getAsInt();
    }
}
