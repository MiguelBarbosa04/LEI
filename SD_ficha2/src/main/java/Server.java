
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author migue
 */
public class Server {

    /**
     * @param args the command line arguments
     */
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
