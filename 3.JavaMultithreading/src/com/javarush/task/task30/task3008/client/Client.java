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

        protected void processIncomingMessage(String message) {
            System.out.println(message);
        }

        protected void informAboutAddingNewUser(String userName) throws IOException {
            System.out.println("Пользователь "+userName+" присоеденился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            System.out.println("Пользователь "+userName+" покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                    Message message = connection.receive();
                    if (message.getType() == MessageType.TEXT) {
                        processIncomingMessage(message.getData());
                    } else if (message.getType() == MessageType.USER_ADDED) {
                        informAboutAddingNewUser(message.getData());
                    } else if (message.getType() == MessageType.USER_REMOVED) {
                        informAboutDeletingNewUser(message.getData());
                    } else {
                        throw new IOException("Unexpected MessageType");
                    }
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
