package com.javarush.task.task16.task1632;

import java.util.*;
import java.util.stream.IntStream;

public class Thread5 extends Thread {
    ArrayList<Integer> numbers = new ArrayList<>();
    @Override
    public void run() {
        super.run();
        try (Scanner scanner = new Scanner(System.in)) {
            for(String line = scanner.nextLine();;line = scanner.nextLine()) {
                if(line.equals("N")) break;
                numbers.add(Integer.parseInt(line));
            }
            System.out.println(numbers.stream().mapToInt(i->i).sum());
        }
    }
}