/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

/**
 *
 * @author Miguel
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MultiServerChat {
    private static final int PORT = 25;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("ChatServer is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(out);

                ClientHandler clientHandler = new ClientHandler(clientSocket, out);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;

        public ClientHandler(Socket socket, PrintWriter out) {
            this.socket = socket;
            this.out = out;
        }

        @Override
        public void run() {
            try {
                clients.forEach(writer -> writer.println("New user connected"));

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message;
                while ((message = in.readLine()) != null) {
                    String formattedMessage = getFormattedMessage(message, socket);
                    clients.forEach(writer -> writer.println(formattedMessage));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(out);
            }
        }

        private String getFormattedMessage(String message, Socket socket) {
            String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
            String clientIP = socket.getInetAddress().getHostAddress();
            return "[" + timestamp + "] " + clientIP + ": " + message;
        }
    }
}
