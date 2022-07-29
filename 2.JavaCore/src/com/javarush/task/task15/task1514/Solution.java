package com.javarush.task.task15.task1514;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.0,"a");
        labels.put(1.10,"adddd");
        labels.put(1.01,"addd");
        labels.put(1.011,"add");
        labels.put(1.0111,"ad");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
