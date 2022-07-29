package com.javarush.task.pro.task13.task1316;

import com.javarush.task.pro.task13.task1316.JavarushQuest;

public class Solution {

    public static void main(String[] args) {
        for (JavarushQuest quest: JavarushQuest.values()) {
            System.out.println(quest.ordinal());
        }
    }
}
