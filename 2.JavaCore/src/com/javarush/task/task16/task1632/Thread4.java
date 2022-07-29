package com.javarush.task.task16.task1632;

public class Thread4 extends Thread implements Message{
    private volatile boolean isCanceled = false;

    @Override
    public void showWarning() {
        isCanceled = true;
    }

    @Override
    public void run() {
        super.run();
        while (!isCanceled) {
        }
    }
}
