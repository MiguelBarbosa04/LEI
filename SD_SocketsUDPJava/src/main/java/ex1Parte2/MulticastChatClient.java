package ex1Parte2;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastChatClient {
    private static final String MULTICAST_GROUP = "230.0.0.1";
    private static final int PORT = 4446;

    public static void main(String[] args) {
        try (MulticastSocket clientSocket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(MULTICAST_GROUP);
            clientSocket.joinGroup(group);

            System.out.println("MulticastChatClient is running...");

            Thread receiverThread = new Thread(() -> {
                try {
                    while (true) {
                        byte[] buffer = new byte[1024];
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        clientSocket.receive(packet);
                        String message = new String(packet.getData(), 0, packet.getLength());
                        System.out.println("Received message: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();

            // Leitura do nome do cliente a partir da entrada do usuário
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            clientName = scanner.nextLine();

            // Envio do nome do cliente para o servidor
            out.println(clientName);

            String userInput;
            // Loop para enviar mensagens para o servidor continuamente
            System.out.print(" --------------------------------------------------\nExemplos de mensagens:\n" + " - mensagem para todos: \"Olá, pessoal\"\n" + " - mensagem privada: \"Para Joaquim Boas, Joaquim!\"\n  --------------------------------------------------\n ");
            while (true) {
                userInput = scanner.nextLine();
                out.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
