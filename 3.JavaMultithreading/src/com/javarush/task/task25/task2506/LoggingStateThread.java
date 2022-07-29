package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread threadView;

    public LoggingStateThread(Thread thread) {
        threadView = thread;
    }

    @Override
    public void run() {
        State currentState = threadView.getState();
        System.out.println(currentState);

        State newState;
        do {
            if ((newState = threadView.getState()) != currentState) {
                currentState = newState;
                System.out.println(newState);
            }
        } while (!currentState.equals(State.TERMINATED));
    }
}
