package ex4;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class ChatClient {
    // Endereço e porta do servidor
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 25;
    private static String clientName;

    public static void main(String[] args) {
        try (
                // Criação de recursos de entrada e saída para comunicação com o servidor
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // Conexão estabelecida com o servidor
            System.out.println("Connected to ChatServer on " + SERVER_ADDRESS + ":" + SERVER_PORT);

            // Thread para receber e exibir mensagens do servidor
            Thread receiverThread = new Thread(() -> {
                String serverResponse;
                try {
                    // Loop para receber mensagens contínuas do servidor
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();

            // Leitura do nome do cliente a partir da entrada do usuário
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            clientName = scanner.nextLine();

            // Envio do nome do cliente para o servidor
            out.println(clientName);

            String userInput;
            // Loop para enviar mensagens para o servidor continuamente
            System.out.print(" --------------------------------------------------\nExemplos de mensagens:\n" + " - mensagem para todos: \"Olá, pessoal\"\n" + " - mensagem privada: \"Para Joaquim Boas, Joaquim!\"\n  --------------------------------------------------\n ");
            while (true) {
                userInput = scanner.nextLine();
                out.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 /* Exemplos de mensagens:
       - mensagem para todos: "Olá, pessoal"
       - mensagem privada: "Para Joaquim Boas, Joaquim!"
       - Caso não exista o destinatário, é recebida uma mensagem informando o mesmo
    */
