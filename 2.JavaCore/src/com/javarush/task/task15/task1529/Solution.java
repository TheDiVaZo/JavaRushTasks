package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        Scanner scanner = new Scanner(System.in);
        String param = scanner.nextLine();
        if(param.equals("helicopter")) result = new Helicopter();
        else if(param.equals("plane")) {
            int param_2 = scanner.nextInt();
            result = new Plane(param_2);
        }
        scanner.close();
    }
}
