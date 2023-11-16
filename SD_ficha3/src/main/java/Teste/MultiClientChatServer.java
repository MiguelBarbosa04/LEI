/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

/**
 *
 * @author Miguel
 */import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MultiClientChatServer {
    private static final int PORT = 8080;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("ChatServer is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());
                ClientHandler client = new ClientHandler(clientSocket);
                clients.add(client);
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                out.println("Enter your name:");
                clientName = in.readLine();
                out.println("Welcome to the chat, " + clientName + "!");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/private")) {
                        sendPrivateMessage(message);
                    } else {
                        broadcastMessage("[" + getTimestamp() + "] " + clientName + ": " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.remove(this);
                broadcastMessage("[" + getTimestamp() + "] " + clientName + " has left the chat.");
            }
        }

        private void sendPrivateMessage(String message) {
            String[] parts = message.split(" ", 3);
            if (parts.length == 3) {
                String recipient = parts[1];
                String privateMessage = "[" + getTimestamp() + "] " + clientName + " (Private): " + parts[2];

                for (ClientHandler client : clients) {
                    if (client.clientName.equals(recipient)) {
                        client.out.println(privateMessage);
                        return;
                    }
                }

                out.println("User '" + recipient + "' not found.");
            } else {
                out.println("Invalid private message format. Use '/private <recipient> <message>'.");
            }
        }

        private void broadcastMessage(String message) {
            for (ClientHandler client : clients) {
                if (client != this) {
                    client.out.println(message);
                }
            }
        }

        private String getTimestamp() {
            return new SimpleDateFormat("HH:mm:ss").format(new Date());
        }
    }
}

