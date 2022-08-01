package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator<T> comparator : comparators) {
                if(result == 0) {
                    result = comparator.compare(o1, o2);
                }
                else break;
            }
            return result;
        }
    }

    /*public static <T> Comparator CustomizedComparator(Comparator<T>[] comparators) {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                int result = 0;
                for (Comparator<T> comparator : comparators) {
                    if(result == 0) {
                        result = comparator.compare(o1, o2);
                    }
                    else break;
                }
                return result;
            }
        };
    }*/
}
