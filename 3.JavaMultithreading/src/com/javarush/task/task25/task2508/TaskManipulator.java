package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    Thread childThread;

    @Override
    public void run() {
        while (childThread.getState() == Thread.State.RUNNABLE) {
            try {
                System.out.println(childThread.getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        childThread = new Thread(this,threadName);
        childThread.start();
    }

    @Override
    public void stop() {
        childThread.interrupt();
    }
}
