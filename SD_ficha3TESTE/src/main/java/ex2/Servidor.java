package ex2;

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

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                ClienteHandler cliente = new ClienteHandler(clienteSocket);
                clientes.add(cliente);
                cliente.start();
            }
        } catch (IOException e) {
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

    public static List<ClienteHandler> getClientes() {
        return clientes;
    }
}
