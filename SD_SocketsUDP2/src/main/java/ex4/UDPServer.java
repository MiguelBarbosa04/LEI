package ex4;

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
import java.util.concurrent.TimeUnit;

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
                    long rtt = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

                    // Verificar se a mensagem recebida pode ser convertida para um número
                    String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    try {
                        long clientTime = Long.parseLong(clientMessage);

                        // Obter o ajustamento (diferença entre o tempo local do servidor e o tempo recebido do cliente)
                        long adjustment = clientTime - (System.currentTimeMillis() + rtt / 2);

                        // Exibir o RTT e o ajustamento
                        System.out.println("RTT: " + rtt + " ms");
                        System.out.println("Ajustamento: " + adjustment + " ms");

                        totalTime += rtt;
                        receivedPackets++;

                        // Construir a resposta para o cliente (incluindo o ajustamento)
                        String response = System.currentTimeMillis() + adjustment + "";
                        byte[] sendData = response.getBytes();

                        // Criar pacote UDP para enviar de volta ao cliente
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());

                        // Enviar o pacote ao cliente
                        serverSocket.send(sendPacket);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Mensagem inválida recebida do cliente");
                    }
                } catch (java.net.SocketTimeoutException e) {
                    System.out.println("Timeout: Pacote perdido");
                }
            }

            // Calcular a percentagem de perda de pacotes
            int lostPackets = totalPackets - receivedPackets;
            double lossPercentage = (double) lostPackets / totalPackets * 100;

            // Exibir informações sobre o desempenho
            System.out.println("Tempo total: " + totalTime + " ms");
            System.out.println("Pacotes recebidos: " + receivedPackets);
            System.out.println("Pacotes perdidos: " + lostPackets);
            System.out.println("Percentagem de perda de pacotes: " + lossPercentage + "%");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
