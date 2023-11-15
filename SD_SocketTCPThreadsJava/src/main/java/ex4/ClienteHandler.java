package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteHandler extends Thread {
    private Socket clienteSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String nome;

    public ClienteHandler(Socket socket) {
        this.clienteSocket = socket;
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
            out.println("Informe seu nome: ");
            nome = in.readLine();
            out.println("Bem-vindo, " + nome + "!");

            String mensagem;
            while ((mensagem = in.readLine()) != null) {
                processAndStoreMessage(mensagem); // Process and store the message centrally
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processAndStoreMessage(String mensagem) {
        // Get timestamp and client IP
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String clientIP = clienteSocket.getInetAddress().getHostAddress();

        // Format the message to include timestamp, client IP, and client name
        String formattedMessage = "[" + timestamp + "] " + nome + " (" + clientIP + "): " + mensagem;

        // Store the formatted message centrally (you can add your storage logic here)
        CentralMessageStorage.storeMessage(formattedMessage);

        // Broadcast the message to all clients
        Servidor.broadcastMessage(formattedMessage);
    }

    public void sendMessage(String message) {
        out.println(message);
    }

}
