package ex1;


import java.io.IOException;
import java.net.ServerSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author migue
 */
public class TcpMultiServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        int port = 25;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port + ". ");
            System.exit(-1);
        }
        
        System.out.println("MultiClientEchoServer is running on port " + port);
       
        while (listening) {
            new WorkerThread(serverSocket.accept()).start();
        }

        serverSocket.close();
    }
}
