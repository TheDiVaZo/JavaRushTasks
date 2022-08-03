package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public void run() {
            System.out.println("установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            String name = null;
            try (Connection connection = new Connection(socket);) {
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                notifyUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("произошла ошибка при обмене данными с удаленным адресом");
            } finally {
                if(name != null) {
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                }
                System.out.println("соединение с удаленным адресом закрыто.");
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message messageUser = connection.receive();
                if (messageUser.getType()==(MessageType.TEXT)) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + messageUser.getData()));
                }
                else ConsoleHelper.writeMessage("Ошибка");
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> connectionEntry : connectionMap.entrySet()) {
                String nameMapsUser = connectionEntry.getKey();
                Connection connectionMapsUser = connectionEntry.getValue();
                if(nameMapsUser.equals(userName)) continue;
                connectionMapsUser.send(new Message(MessageType.USER_ADDED, userName));
                connection.send(new Message(MessageType.USER_ADDED, nameMapsUser));
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message responseName = null;
            do {
                connection.send(new Message(MessageType.NAME_REQUEST));
                responseName = connection.receive();
            }
            while (!responseName.getType().equals(MessageType.USER_NAME) || responseName.getData() == null || "".equals(responseName.getData()) || connectionMap.containsKey(responseName.getData()));
            connectionMap.put(responseName.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return responseName.getData();
        }

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void sendBroadcastMessage(Message message) {
        connectionMap.values().forEach((connection -> {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не отправелось.");
            }
        }));
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
