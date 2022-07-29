package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 3; i += 3) {
                        String[] argus = new String[4];
                        System.arraycopy(args, i, argus, 1, 3);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        allPeople.add(
                                argus[2].equals("ж") ?
                                        Person.createFemale(argus[1], format.parse(argus[3])) :
                                        Person.createMale(argus[1], format.parse(argus[3])));
                        System.out.println(allPeople.size() - 1);
                    }
                }

                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 4; i += 4) {
                        String[] argus = new String[5];
                        System.arraycopy(args, i, argus, 1, 4);
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        Person people = allPeople.get(Integer.parseInt(argus[1]));
                        people.setName(argus[2]);
                        people.setSex(argus[3].equals("ж") ? Sex.FEMALE : Sex.MALE);
                        people.setBirthDate(format.parse(argus[4]));
                    }
                }

                //System.out.println(allPeople.get(1).getName());

                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 1; i += 1) {
                        String[] argus = new String[2];
                        System.arraycopy(args, i, argus, 1, 1);
                        Person people = allPeople.get(Integer.parseInt(argus[1]));
                        people.setName(null);
                        people.setSex(null);
                        people.setBirthDate(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i <= args.length - 1; i += 1) {
                        String[] argus = new String[2];
                        System.arraycopy(args, i, argus, 1, 1);
                        Person person = allPeople.get(Integer.parseInt(argus[1]));
                        String date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate());
                        System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + date);
                    }
                    break;
                }
        }
    }
}
