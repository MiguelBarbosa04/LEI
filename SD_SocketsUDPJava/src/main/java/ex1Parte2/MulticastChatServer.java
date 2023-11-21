package ex1Parte2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MulticastChatServer {

    private static final String MULTICAST_GROUP = "230.0.0.1";
    private static final int PORT = 4446;

    public static void main(String[] args) {
        try ( MulticastSocket serverSocket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(MULTICAST_GROUP);
            serverSocket.joinGroup(group);

            System.out.println("MulticastChatServer is running on group " + MULTICAST_GROUP);

            while (true) {
                // Read messages from some source (e.g., a central message storage)
                List<String> messages = CentralMessageStorage.getAllMessages();

                for (String message : messages) {
                    // Broadcast the message to all clients in the multicast group
                    byte[] buffer = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);
                    serverSocket.send(packet);
                }

                // Simulate some delay before broadcasting again
                Thread.sleep(5000); // Adjust the interval as needed
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
