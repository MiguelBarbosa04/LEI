package ex1;

import java.io.*;
import java.net.*;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverSocket = new ServerSocket(25);
            System.out.println("Server listening on port 25...");
        } catch (IOException e) {
            System.out.println("Could not listen on port: 25");
            System.exit(-1);
        }

        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected...");
        } catch (IOException e) {
            System.out.println("Accept failed!");
            System.exit(-1);
        }

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String userInput;

        while ((userInput = in.readLine()) != null) {
            System.out.println(serverSocket + ":" + clientSocket + ":" + userInput);
            out.println(serverSocket + ":" + clientSocket + ":" + userInput);
           
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
