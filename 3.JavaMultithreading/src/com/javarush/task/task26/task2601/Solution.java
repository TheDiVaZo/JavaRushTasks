package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Integer[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        double mediana;
        if(sortedArray.length % 2 != 0) mediana = sortedArray[(int) Math.ceil(sortedArray.length / 2)];
        else mediana = (sortedArray[sortedArray.length/2] + sortedArray[(sortedArray.length/2)-1]) / 2;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double resultO1 = Math.abs(o1-mediana);
                double resultO2 = Math.abs(o2-mediana);
                if(resultO1 == resultO2) {
                    return o1-o2;
                }
                else return (int) (resultO1-resultO2);
            }
        };
        Arrays.sort(sortedArray, comparator);
        return sortedArray;
    }
}
