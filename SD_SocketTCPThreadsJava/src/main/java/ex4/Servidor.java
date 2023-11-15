package ex4;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private static List<ClienteHandler> clientes = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int porta = 25;

        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Servidor iniciado na porta " + porta);

            // Thread for accepting client connections
            ServerSocket finalServerSocket = serverSocket;
            Thread acceptThread = new Thread(() -> {
                while (true) {
                    try {
                         Socket clienteSocket = finalServerSocket.accept();
                        ClienteHandler cliente = new ClienteHandler(clienteSocket);
                        clientes.add(cliente);
                        cliente.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            acceptThread.start();

            // Thread for periodically broadcasting messages
            Thread broadcastThread = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(5000); // Adjust the interval as needed
                        broadcastMessages();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            broadcastThread.start();

            acceptThread.join();
            broadcastThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void broadcastMessages() {
        List<String> allMessages = CentralMessageStorage.getAllMessages();
        for (ClienteHandler client : clientes) {
            for (String message : allMessages) {
                client.sendMessage(message);
            }
        }
    }

    public static List<ClienteHandler> getClientes() {
        return clientes;
    }

    public static void broadcastMessage(String message) {
        for (ClienteHandler client : clientes) {
            client.sendMessage(message);
        }
    }
}
