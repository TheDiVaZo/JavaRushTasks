package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(2005, Calendar.JANUARY, 10);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "воскресенье";
            case 2:
                return "понедельник";
            case 3:
                return "вторник";
            case 4:
                return "среда";
            case 5:
                return "четверг";
            case 6:
                return "пятница";
            case 7:
                return "суббота";
        }

        return null;
    }
}
