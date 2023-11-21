package ex1;
import java.io.IOException;
import java.net.*;

public class QuoteClient {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java QuoteClient <hostname>");
            return;
        }

        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = new byte[256];
            InetAddress address = InetAddress.getByName(args[0]);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 25);
            socket.send(packet);

            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Quote of the Moment: " + received);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
