package ex3;

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

            // Criar socket UDP com timeout de 5 segundos
            DatagramSocket serverSocket = new DatagramSocket(serverPort);
            serverSocket.setSoTimeout(5000);

            System.out.println("Servidor UDP aguardando conexões...");

            int totalPackets = 10;  // Número total de datagramas a serem enviados
            int receivedPackets = 0;  // Contador para pacotes recebidos

            long totalTime = 0;  // Acumulador para calcular o tempo total

            while (receivedPackets < totalPackets) {
                // Preparar o pacote para receber a mensagem do cliente
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Registrar o tempo de início
                long startTime = System.nanoTime();

                try {
                    // Aguardar por mensagens dos clientes
                    serverSocket.receive(receivePacket);

                    // Registrar o tempo de término
                    long endTime = System.nanoTime();

                    // Calcular o Round-Trip Time (RTT) em milissegundos
                    long rtt = (endTime - startTime) / 1000000;

                    // Exibir o RTT
                    System.out.println("RTT: " + rtt + " ms");

                    totalTime += rtt;
                    receivedPackets++;

                    // Calcular a percentagem de perda de pacotes
                    int lostPackets = totalPackets - receivedPackets;
                    double lossPercentage = (double) lostPackets / totalPackets * 100;

                    // Exibir informações sobre o desempenho
                    System.out.println("Tempo total: " + totalTime + " ms");
                    System.out.println("Pacotes recebidos: " + receivedPackets);
                    System.out.println("Pacotes perdidos: " + lostPackets);
                    System.out.println("Percentagem de perda de pacotes: " + lossPercentage + "%");
                } catch (java.net.SocketTimeoutException e) {
                    System.out.println("Timeout: Pacote perdido");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
