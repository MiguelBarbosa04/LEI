package ex2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 25;
    private static String clientName;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Connected to ChatServer on " + SERVER_ADDRESS + ":" + SERVER_PORT);

            Thread receiverThread = new Thread(() -> {
                String serverResponse;
                try {
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println(serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            clientName = scanner.nextLine();
            out.println(clientName);

            String userInput;
            while (true) {
                System.out.print("Enter recipient and message (e.g., 'Alice: Hello'): ");
                userInput = scanner.nextLine();
                out.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
