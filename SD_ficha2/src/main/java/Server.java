
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int portNumber = 25; // Porta do servidor

        try ( ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Servidor Knock-Knock está aguardando conexões na porta " + portNumber);

            while (true) {
                // Espera por uma conexão de cliente
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                try (
                         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    // Inicia o  "Knock-Knock" enviando a primeira mensagem
                    out.println("Knock! Knock!");
                    // Cria uma instância do protocolo para gerenciar a conversa
                    KnockKnockProtocol protocol = new KnockKnockProtocol();
                    String clientInput;

                    // Entra em loop para lidar com a conversa
                    while ((clientInput = in.readLine()) != null) {
                        // Processa a entrada do cliente usando o protocolo
                        String serverResponse = protocol.processInput(clientInput);
                        // Envia a resposta do servidor de volta ao cliente
                        out.println(serverResponse);

                        // Verifica se o cliente escolheu encerrar a conversa
                        if (serverResponse.equals("Bye.")) {
                            break;
                        }
                    }
                    ;

                } catch (IOException e) {
                    System.err.println("Erro na comunicação com o cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}
