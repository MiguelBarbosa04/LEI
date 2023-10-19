/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class HelloThread implements Runnable {

    private int threadNumber;
    private int seconds;

    public HelloThread(int threadNumber, int seconds) {
        this.threadNumber = threadNumber;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (int count = 0; count <= seconds; count++) {
            System.out.println("[" + threadName + "] Eu sou uma thread!");
            try {
                sleep(1000);
                count++;
            } catch (InterruptedException ex) {
                Logger.getLogger(HelloThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("Modo de uso: java Ex1 <comando>");
            System.exit(0);
        }

        int seconds = Integer.parseInt(args[0]);

        Thread thread = new Thread(new HelloThread(1, seconds));

        thread.setName("Thread 1");
        thread.start();

    }
}
