package ex1;

import java.io.*;
import java.net.*;

public class QuoteServerThread extends Thread {

    private DatagramSocket socket;
    private BufferedReader in;

    public QuoteServerThread() throws IOException {
        this("QuoteServer");
    }

    public QuoteServerThread(String name) throws IOException {
        super(name);
        socket = new DatagramSocket(25);

        try {
            in = new BufferedReader(new FileReader("C:/Users/migue/Documents/NetBeansProjects/SD_SocketsUDPJava/src/main/java/ex1/one-liners.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't open quote file. Serving time instead.");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                String dString = null;
                if (in == null) {
                    dString = new java.util.Date().toString();
                } else {
                    dString = getNextQuote();
                }

                buf = dString.getBytes();

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    private String getNextQuote() throws IOException {
        String quote = in.readLine();
        if (quote == null) {
            in.close();
            in = new BufferedReader(new FileReader("one-liners.txt"));
            quote = in.readLine();
        }
        return quote;
    }
}
