package com.javarush.task.task17.task1710;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>(10);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if(args[0].equals("-c")) {
            if(args.length < 4) return;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            allPeople.add(
                    args[2].equals("ж") ?
                    Person.createFemale(args[1], format.parse(args[3])):
                            Person.createMale(args[1], format.parse(args[3])));
            System.out.println(allPeople.size()-1);

        }
        else if(args[0].equals("-r")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH). format(person.getBirthDate());
            System.out.println(person.getName() +" "+ (person.getSex().equals(Sex.MALE) ? "м":"ж") + " " + date);
        }
        else if(args[0].equals("-u")) {
            if(args.length < 5) return;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Person people = allPeople.get(Integer.parseInt(args[1]));
            people.setName(args[2]);
            people.setSex(args[3].equals("ж") ? Sex.FEMALE:Sex.MALE);
            people.setBirthDate(format.parse(args[4]));

            //System.out.println(allPeople.get(1).getName());

        }
        else if(args[0].equals("-d")) {
            Person people = allPeople.get(Integer.parseInt(args[1]));
            people.setName(null);
            people.setSex(null);
            people.setBirthDate(null);
        }
    }
}
