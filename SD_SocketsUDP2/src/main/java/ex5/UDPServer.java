package ex5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author migue
 */import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Porta do servidor
            int serverPort = 12345;

            // Criar socket UDP
            DatagramSocket serverSocket = new DatagramSocket(serverPort);

            // Aguardar por mensagens dos clientes
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // Obter o tempo recebido do cliente como uma string
            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Verificar se a mensagem recebida pode ser convertida para um número
            try {
                long clientTime = Long.parseLong(clientMessage);

                // Exibir a mensagem recebida para depuração
                System.out.println("Servidor recebeu o tempo: " + clientTime);

                // Restante do código...

                // Exemplo: Enviar uma resposta de volta para o cliente
                String response = "Servidor recebeu o tempo: " + clientTime;
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sendPacket);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Mensagem inválida recebida do cliente");
            }

            // Fechar o socket do servidor
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

