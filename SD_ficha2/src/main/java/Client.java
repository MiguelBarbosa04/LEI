/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author migue
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author migue
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String serverAddress = "localhost"; // Endereço do servidor
        int serverPort = 25; // Porta do servidor

        try ( Socket socket = new Socket(serverAddress, serverPort);  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String serverResponse;

            while ((serverResponse = in.readLine()) != null) {
                System.out.println("Servidor: " + serverResponse);

                if (serverResponse.equals("Bye.")) {
                    break;
                }

                String userInput = stdIn.readLine();// Lê a entrada do usuário a partir do console
                if (userInput != null) {
                    out.println(userInput);// Envia a entrada do usuário para o servidor
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao se conectar ao servidor: " + e.getMessage());
        }
    }
}
