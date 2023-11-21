package ex1Parte2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastChatClient {
    private static final String GROUP_ADDRESS = "230.0.0.1";
    private static final int PORT = 4446;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try (MulticastSocket clientSocket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(GROUP_ADDRESS);
            clientSocket.joinGroup(group);

            System.out.println("MulticastChatClient is running...");

            Thread receiverThread = new Thread(() -> {
                try {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    while (true) {
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        clientSocket.receive(packet);
                        String message = new String(packet.getData(), 0, packet.getLength());
                        System.out.println("Received message: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter your message: ");
                String message = scanner.nextLine();
                sendMessage(message, clientSocket, group);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage(String message, MulticastSocket socket, InetAddress group) throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);
        socket.send(packet);
    }
}
