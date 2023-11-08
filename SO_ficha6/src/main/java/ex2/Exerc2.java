/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.*;
import java.util.concurrent.Semaphore;

public class Exerc2 implements Runnable {

    Semaphore s1, s2;
    PrintWriter writer; // Variável para escrever no arquivo

    public Exerc2(Semaphore sem1, Semaphore sem2, PrintWriter writer) {
        s1 = sem1;
        s2 = sem2;
        this.writer = writer;
    }

    @Override
    public void run() {
        boolean flag = true;

        try {
            String myname = Thread.currentThread().getName();

            while (flag) {
                s1.acquire();
                if (s2.availablePermits() > 0) {
                    writer.println("[" + myname + "] : linha " + s2.availablePermits());
                    s2.acquire();
                } else {
                    flag = false;
                }

                s1.release();
                Thread.sleep(1000);
            }
        } catch (InterruptedException iex) {
        }
    }

    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Uso: java Exerc2 <arquivo_de_saida>");
            System.exit(1);
        }

        final Semaphore sem1 = new Semaphore(1);
        final Semaphore sem2 = new Semaphore(10);

        try {
            String outputFile = args[0];
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile)) // Abre o arquivo para escrita
            ) {
                Thread[] ths = new Thread[20];
                for (int i = 0; i < 20; i++) {
                    ths[i] = new Thread(new Exerc2(sem1, sem2, writer), "Th" + i);
                }   for (int i = 0; i < 20; i++) {
                    ths[i].start();
                }   for (int i = 0; i < 20; i++) {
                    ths[i].join();
                }
                // Fecha o arquivo quando terminar de escrever
            }
        } catch (IOException | InterruptedException e) {
        }
    }
}