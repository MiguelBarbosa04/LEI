package ex2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author migue
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Porta do servidor
            int serverPort = 12345;

            // Criar socket UDP
            DatagramSocket serverSocket = new DatagramSocket(serverPort);

            System.out.println("Servidor UDP aguardando conexões...");

            while (true) {
                // Preparar o pacote para receber a mensagem do cliente
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Aguardar por mensagens dos clientes
                serverSocket.receive(receivePacket);

                // Obter o endereço do cliente e a porta
                // (Isso deve estar dentro do loop para obter o endereço correto a cada iteração)
                java.net.InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Exibir o endereço e a porta do cliente
                System.out.println("Conexão recebida de " + clientAddress + "- Cliente port: " + clientPort);

                // Obter o tempo local e formatar como string
                String serverTime = java.time.LocalTime.now().toString();

                // Converter a string para bytes
                byte[] sendData = serverTime.getBytes();

                // Criar pacote UDP para enviar de volta ao cliente
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                // Enviar o pacote ao cliente
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
