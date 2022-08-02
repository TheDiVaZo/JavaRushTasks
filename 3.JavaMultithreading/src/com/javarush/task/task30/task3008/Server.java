package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) throws IOException {

        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("сервер запущен.");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            } catch (Exception e) {
                serverSocket.close();
                e.printStackTrace();
                break;
            }
        }
    }
}
