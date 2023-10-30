package ex2;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MultiClientChatServer {
    private static final int PORT = 25;
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
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                out.println("Enter your name:");
                clientName = in.readLine();
                out.println("Welcome to the chat, " + clientName + "!");

                String message;
                while ((message = in.readLine()) != null) {
                    String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
                    String formattedMessage = "[" + timestamp + "] " + clientName + ": " + message;

                    System.out.println(clientName + " sent: " + formattedMessage);
                    sendToRecipient(clientName, formattedMessage);
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
                sendToRecipient(clientName, clientName + " has left the chat.");
            }
        }

        public void sendToRecipient(String sender, String message) {
            for (ClientHandler client : clients) {
                if (client != this && client.clientName != null && !client.clientName.equals(sender)) {
                    client.out.println(message);
                }
            }
        }
    }
}
