package ex1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author migue
 */

import java.io.IOException;
import java.net.*;

public class BerkeleyServer {

    public static void main(String[] args) {
        // Grupo de Multicast e porta
        String multicastGroup = "224.0.0.1";
        int port = 9876;

        // Número de clientes conhecido
        int numClients = 5;

        try {
            // Criar socket de multicast
            MulticastSocket socket = new MulticastSocket();

            // Juntar-se ao grupo de multicast
            InetAddress group = InetAddress.getByName(multicastGroup);
            socket.joinGroup(group);

            // Enviar pedido para obter o tempo
            String request = "Qual é o tempo local?";
            byte[] requestData = request.getBytes();
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, group, port);
            socket.send(requestPacket);

            // Definir um temporizador para evitar bloqueio indefinido
            socket.setSoTimeout(5000); // 5000 milissegundos (5 segundos)

            // Receber respostas dos clientes
            long totalOffset = 0;
            for (int i = 0; i < numClients; i++) {
                byte[] responseData = new byte[1024];
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);

                try {
                    socket.receive(responsePacket);
                    String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                    long clientTime = Long.parseLong(response);
                    long serverTime = System.currentTimeMillis();
                    long offset = clientTime - serverTime;
                    totalOffset += offset;

                    System.out.println("Resposta do Cliente " + (i + 1) + ": " + response);
                } catch (SocketTimeoutException e) {
                    System.out.println("Tempo expirado. Nenhuma resposta do Cliente " + (i + 1));
                }
            }

            // Calcular o ajuste de tempo médio
            long averageOffset = totalOffset / numClients;
            System.out.println("Ajuste de tempo médio: " + averageOffset + " milissegundos");

            // Sair do grupo de multicast
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
