/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author migue
 */
import java.io.IOException;
import java.net.*;

public class MulticastClient {
    public static void main(String[] args) throws IOException {

        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress group = InetAddress.getByName("224.0.0.2");

        // Obtenha a interface de rede padrão
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());

        // Substitua o joinGroup e leaveGroup com os métodos que usam NetworkInterface
        socket.joinGroup(new InetSocketAddress(group, 4446), networkInterface);

        DatagramPacket packet;

        for (int i = 0; i < 5; i++) {
            byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            // Especifica o comprimento real dos dados recebidos
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Quote of the Moment: " + received);
        }

        // Substitua leaveGroup com o método que usa NetworkInterface
        socket.leaveGroup(new InetSocketAddress(group, 4446), networkInterface);
        socket.close();
    }
}
    /* CERTOS METODOS DOS IMPORTS ESTAVAMA  DAR CONFLITO POR SEREM OBSOLETOS
        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress group = InetAddress.getByName("224.0.0.2");
        socket.joinGroup(group);

        DatagramPacket packet;
        for (int i = 0; i < 5; i++) {
            byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String received = new String(packet.getData());
            System.out.println("Quote of the Moment: " + received);
        }

        socket.leaveGroup(group);
        socket.close();
    }
}
*/
