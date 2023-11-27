/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author migue
 */
import java.io.IOException;
import java.net.*;

public class BerkeleyClient {

    public static void main(String[] args) {
        int port = 9876;

        try {
            MulticastSocket socket = new MulticastSocket(port);
            InetAddress group = InetAddress.getByName("224.0.0.1");
            socket.joinGroup(group);

            byte[] requestData = new byte[1024];
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length);
            socket.receive(requestPacket);

            long clientTime = System.currentTimeMillis();
            byte[] responseData = String.valueOf(clientTime).getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, group, port);
            socket.send(responsePacket);

            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
