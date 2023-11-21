package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static String clientName;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Connected to ChatServer on " + SERVER_ADDRESS + ":" + SERVER_PORT);

            Thread receiveThread = new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            Scanner scanner = new Scanner(System.in);

            Thread sendThread = new Thread(() -> {
                System.out.print("Enter your name: ");
                clientName = scanner.nextLine();
                out.println(clientName);

                String userInput;
                while (true) {
                    System.out.print("Enter message: ");
                    userInput = scanner.nextLine();
                    out.println(userInput);
                }
            });
            sendThread.start();

            // Wait for both threads to finish
            receiveThread.join();
            sendThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
