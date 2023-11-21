/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author migue
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class MulticastServerThread extends QuoteServerThread {

    private long FIVE_SECONDS = 5000;

    public MulticastServerThread() throws IOException {
        super("MulticastServerThread");
    }

    @Override
    public void run() {
        while (moreQuotes) {
            try {
                byte[] buf = new byte[256];

                    // construct quote
                String dString = null;
                if (in == null)
                    dString = new Date().toString();
                else
                    dString = getNextQuote();
                buf = dString.getBytes();


                InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                socket.send(packet);


		try {
		    sleep((long)(Math.random() * FIVE_SECONDS));
		} catch (InterruptedException e) { }
            } catch (IOException e) {
                e.printStackTrace();
		moreQuotes = false;
            }
        }
	socket.close();
    }
}