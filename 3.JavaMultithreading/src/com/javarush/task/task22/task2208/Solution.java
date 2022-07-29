package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, String> entry:params.entrySet()) {
            if(entry.getValue() != null) {
                result.append(entry.getKey() + " = " + "'"+entry.getValue()+"'" + " and ");
            }
        }
        return  result.toString().replaceAll(" and $", "");
    }
}
