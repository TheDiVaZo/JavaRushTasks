package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            System.out.println("Ошибка");
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread {

        @Override
        public void run() {
            try {
                connection = new Connection(new Socket(InetAddress.getByName(getServerAddress()),getServerPort()));
                clientConnected = true;
                Client.this.notify();
            } catch (IOException e) {
                e.printStackTrace();
                clientConnected = false;
            }

        }
    }

    public void run() throws InterruptedException {
        SocketThread connectedThread = getSocketThread();
        connectedThread.setDaemon(true);
        connectedThread.start();
        synchronized (this) {
            wait();
            if(clientConnected) System.out.println("Соединение установлено. Для выхода наберите команду 'exit'.");
            else System.out.println("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            String message = ConsoleHelper.readString();
            if("exit".equals(message)) break;
            if(shouldSendTextFromConsole()) sendTextMessage(message);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Client().run();
    }
}
