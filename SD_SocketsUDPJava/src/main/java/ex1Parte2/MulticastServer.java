package ex1Parte2;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.io.BufferedReader;


public class MulticastServer {
    private static final int PORT = 8081;
    private static final String MULTICAST_GROUP = "230.0.0.0";

    public static void main(String[] args) {
        try (MulticastSocket multicastSocket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(MULTICAST_GROUP);
            multicastSocket.joinGroup(group);

            System.out.println("MulticastServer is running on port " + PORT);

            while (true) {
                // Read messages from wherever you get them
                String message = getMessage();

                // Broadcast the message to all clients in the multicast group
                DatagramPacket packet = new DatagramPacket(
                        message.getBytes(),
                        message.length(),
                        group,
                        PORT
                );
                multicastSocket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcastMessage(String message, MulticastSocket multicastSocket, InetAddress group)
            throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);
        multicastSocket.send(packet);
    }

    private static String getMessage() {
        // Read messages from the console
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter message to broadcast: ");
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading message";
        }
    }
}
