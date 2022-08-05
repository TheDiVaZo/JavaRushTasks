package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() throws InterruptedException {
        while (!isValuePresent) {
            wait();
        }
        isValuePresent = false;
        notifyAll();
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) throws InterruptedException {
        while (isValuePresent) {
            wait();
        }
        isValuePresent = true;
        this.value = value;
        notifyAll();
        System.out.println("Put: " + value);
    }
}
