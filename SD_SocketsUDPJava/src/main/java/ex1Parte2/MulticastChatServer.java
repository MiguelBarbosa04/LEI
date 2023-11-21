package ex1Parte2;

import java.io.IOException;
        import java.net.DatagramPacket;
        import java.net.InetAddress;
        import java.net.MulticastSocket;
        import java.text.SimpleDateFormat;
        import java.util.Date;

public class MulticastChatServer {
    private static final int PORT = 4446;
    private static final String GROUP_ADDRESS = "230.0.0.1";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try (MulticastSocket serverSocket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(GROUP_ADDRESS);
            serverSocket.joinGroup(group);

            System.out.println("MulticastChatServer is running on port " + PORT);

            byte[] buffer = new byte[BUFFER_SIZE];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);

                // Process the received message (you can implement your logic here)

                // Broadcast the message to all clients
                broadcastMessage(message, serverSocket, group);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcastMessage(String message, MulticastSocket socket, InetAddress group) throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);
        socket.send(packet);
    }
}
