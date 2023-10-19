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

    public HelloThread(int threadNumber) {
        this.threadNumber = threadNumber;

    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        int nLinhas = 10;
        for (int i = 0; i < nLinhas; i++) {
            System.out.println("[" + threadName + "] Eu sou uma thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HelloThread.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
    }

    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("Modo de uso: java Ex1 <comando>");
            System.exit(0);
        }

        int seconds = Integer.parseInt(args[0]);

        Thread thread = new Thread(new HelloThread(1));
        thread.setName("Thread 1");
        thread.start();

        try {
            Thread.sleep(seconds * 1000); // 
        } catch (InterruptedException ex) {
            Logger.getLogger(HelloThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        thread.interrupt();
    }
}
