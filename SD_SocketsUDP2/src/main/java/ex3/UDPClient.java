/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author migue
 */



import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Endereço e porta do servidor
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;

            // Criar socket UDP
            DatagramSocket clientSocket = new DatagramSocket();

            int totalPackets = 10; // Número total de datagramas a serem enviados

            for (int i = 0; i < totalPackets; i++) {
                // Mensagem a ser enviada
                String message = "Pedido de tempo";
                byte[] sendData = message.getBytes();

                // Criar pacote UDP
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);

                // Enviar pacote para o servidor
                clientSocket.send(sendPacket);

                // Preparar o pacote para receber a resposta do servidor
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Aguardar pela resposta do servidor
                clientSocket.receive(receivePacket);

                // Exibir a resposta do servidor
                String serverTime = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Tempo local do servidor: " + serverTime);
            }

            // Fechar o socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
