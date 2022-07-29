package com.javarush.task.pro.task14.task1401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Поработай обработчиком
*/

public class Solution {

    public static final String INPUT_NAME = "\nВведите имя: ";
    public static final String INPUT_AGE = "Введите возраст пользователя '%s': ";

    public static final String CANNOT_BE_NULL = "Имя не может быть null.";
    public static final String CANNOT_BE_EMPTY = "Имя не может быть пустым.";
    public static final String CANNOT_CONTAIN_DIGIT = "Имя не может содержать цифры.";
    public static final String CANNOT_BE_NEGATIVE = "Возраст не может быть меньше 0.";
    public static final String CANNOT_BE_TOO_BIG = "Возраст не может быть больше 150.";
    public static final String UNKNOWN_ERROR = "Неизвестная ошибка.";

    public static final String FOUND = "\nПользователь '%s' найден под индексом %d.\n";
    public static final String NOT_FOUND = "\nПользователь '%s' не найден.\n";

    static List<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            addUser(new User());
        }

        User userToSearch = new User();
        userToSearch.setName("Рафаэль");

        findUserIndex(userToSearch);
    }

    static void addUser(User user) {
        System.out.print(INPUT_NAME);
        String name = scanner.nextLine();

        System.out.printf(INPUT_AGE, name);
        int age = Integer.parseInt(scanner.nextLine());

        //напишите тут ваш код
        int error_name = user.setName(name);
        if (error_name == -1) {
            System.out.println(CANNOT_BE_NULL);
            return;
        } else if (error_name == -2) {
            System.out.println(CANNOT_BE_EMPTY);
            return;
        } else if (error_name == -3) {
            System.out.println(CANNOT_CONTAIN_DIGIT);
            return;
        } else if (error_name != 0) {
            System.out.println(UNKNOWN_ERROR);
            return;
        }

        int error_age = user.setAge(age);
        if (error_age == -1) {
            System.out.println(CANNOT_BE_NEGATIVE);
            return;
        } else if (error_age == -2) {
            System.out.println(CANNOT_BE_TOO_BIG);
            return;
        } else if (error_age != 0) {
            System.out.println(UNKNOWN_ERROR);
            return;
        }

        users.add(user);
    }

    static void findUserIndex(User user) {
        int error_index = users.indexOf(user);
        if (error_index == -1) {System.out.println(String.format("Пользователь '%s' не найден.", user.getName()));return;}
        System.out.printf(FOUND, user.getName(), users.indexOf(user));
    }
}
