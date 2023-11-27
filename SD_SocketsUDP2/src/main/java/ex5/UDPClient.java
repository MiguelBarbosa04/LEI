/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

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
            // Endereço do servidor e porta
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;

            // Criar socket UDP
            DatagramSocket clientSocket = new DatagramSocket();

            // Obter o tempo local do cliente como um número longo
            long clientTime = System.currentTimeMillis();

            // Enviar o tempo local como uma string para o servidor
            String request = Long.toString(clientTime);
            byte[] sendData = request.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            // Aguardar resposta do servidor
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            // Exibir a resposta do servidor
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Resposta do servidor: " + serverResponse);

            // Fechar o socket do cliente
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
