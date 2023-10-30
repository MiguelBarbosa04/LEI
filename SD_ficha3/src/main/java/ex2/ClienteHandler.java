/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Miguel
 */
public class ClienteHandler extends Thread {

    /**
     * @param args the command line arguments
     */
    private Socket clienteSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String nome;

    public ClienteHandler(Socket socket) {
        this.clienteSocket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            out.println("Informe seu nome: ");
            nome = in.readLine();
            out.println("Bem-vindo, " + nome + "!");
            String mensagem;
            while ((mensagem = in.readLine()) != null) {
                System.out.println(nome + ": " + mensagem);
                enviarMensagemParaDestinatario(mensagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarMensagemParaDestinatario(String mensagem) {
        String[] partes = mensagem.split(" ");
        if (partes.length >= 3 && partes[0].equals("Para")) {
            String destinatario = partes[1];
            String mensagemDestinatario = nome + " (Privado): ";
            for (int i = 2; i < partes.length; i++) {
                mensagemDestinatario += partes[i] + " ";
            }
            for (ClienteHandler cliente : Servidor.getClientes()) {
                if (cliente.nome.equals(destinatario)) {
                    cliente.out.println(mensagemDestinatario);
                    return;
                }
            }
            out.println("Destinatário não encontrado.");
        } else {
            for (ClienteHandler cliente : Servidor.getClientes()) {
                if (cliente != this) {
                    cliente.out.println(nome + ": " + mensagem);
                }
            }
        }
    }
}
