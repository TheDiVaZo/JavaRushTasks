package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> keys = new ArrayList<>();

        for (String line = reader.readLine(); ; line = reader.readLine()) {
            if (line.equalsIgnoreCase("user") ||
                    line.equalsIgnoreCase("loser") ||
                    line.equalsIgnoreCase("coder") ||
                    line.equalsIgnoreCase("proger")) keys.add(line);
            else break;
        }
        keys.forEach((key)->{
            switch (key) {
                case "user": {
                    doWork(new Person.User());
                    break;
                }
                case "loser": {
                    doWork(new Person.Loser());
                    break;
                }
                case "coder": {
                    doWork(new Person.Coder());
                    break;
                }
                case "proger": {
                    doWork(new Person.Proger());
                    break;
                }
            }
        });


    }

    public static void doWork(Person person) {
        if(person instanceof Person.User) {
            ((Person.User) person).live();
        }
        else if(person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        else if(person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
        else if(person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        }
    }
}
