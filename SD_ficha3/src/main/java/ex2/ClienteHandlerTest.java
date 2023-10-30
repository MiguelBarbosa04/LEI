/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.*;
import java.net.Socket;
import java.net.*;

public class ClienteHandlerTest {
    public static void main(String[] args) {
        try {
            // Conectando a um servidor em localhost, porta 25
            Socket clienteSocket = new Socket("localhost", 25);

            // Criar uma instância de ClienteHandler e iniciar o cliente
            ClienteHandler clienteHandler = new ClienteHandler(clienteSocket);
            clienteHandler.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
