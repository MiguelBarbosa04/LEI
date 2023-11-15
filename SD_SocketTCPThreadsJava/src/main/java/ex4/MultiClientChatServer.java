package ex4;

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
                // Aguarda e aceita a conexão de um novo cliente
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Cria uma instância de ClientHandler para lidar com a comunicação do cliente
                ClientHandler client = new ClientHandler(clientSocket);

                // Adiciona o ClienteHandler à lista de clientes
                clients.add(client);

                // Inicia a thread ClienteHandler para gerenciar a comunicação com o cliente
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Classe interna que representa um manipulador de cliente
    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                // Cria um PrintWriter para enviar mensagens para o cliente
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try (
                    // Cria um BufferedReader para ler mensagens do cliente
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                // Solicita ao cliente para inserir seu nome
                out.println("Enter your name:");
                clientName = in.readLine();

                // Envia uma mensagem de boas-vindas ao cliente
                out.println("Welcome to the chat, " + clientName + "!");

                String message;
                // Loop para receber e enviar mensagens enquanto o cliente estiver conectado
                while ((message = in.readLine()) != null) {
                    // Obtém a hora atual formatada
                    String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());

                    // Formata a mensagem para incluir o nome do cliente e o horário
                    String formattedMessage = "[" + timestamp + "] " + clientName + ": " + message;

                    // Exibe a mensagem no servidor
                    System.out.println(clientName + " sent: " + formattedMessage);

                    // Envia a mensagem para todos os outros clientes
                    sendToRecipient(clientName, formattedMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Fecha o socket quando o cliente desconectar
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Remove o ClienteHandler da lista de clientes
                clients.remove(this);

                // Informa aos outros clientes que este cliente saiu do chat
                sendToRecipient(clientName, clientName + " has left the chat.");
            }
        }

        // Método para enviar uma mensagem para todos os outros clientes
        public void sendToRecipient(String sender, String message) {
            for (ClientHandler client : clients) {
                // Verifica se o cliente não é o remetente da mensagem
                // e se o nome do cliente é conhecido (não é nulo)
                if (client != this && client.clientName != null && !client.clientName.equals(sender)) {
                    // Envia a mensagem para o cliente
                    client.out.println(message);
                }
            }
        }
    }
}
