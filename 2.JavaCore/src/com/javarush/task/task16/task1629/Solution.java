package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Только по-очереди!
*/

public class Solution {
    public static class Read3Strings extends Thread {
        private String line;
        ArrayList<String> list = new ArrayList<>();

        @Override
        public void run() {
            super.run();
            try {
                list.add(reader.readLine());
                list.add(reader.readLine());
                list.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void printResult() {
            System.out.println(String.join(" ", list));;
        }
    }

    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
}
