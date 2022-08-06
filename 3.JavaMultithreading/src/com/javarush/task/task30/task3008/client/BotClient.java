package com.javarush.task.task30.task3008.client;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) throws InterruptedException {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread {

    }
}