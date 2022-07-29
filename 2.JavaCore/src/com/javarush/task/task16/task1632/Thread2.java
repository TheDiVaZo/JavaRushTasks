package com.javarush.task.task16.task1632;

public class Thread2 extends Thread {
    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
}