/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.concurrent.*;
import java.util.Random;

public class Th1 implements Runnable {

    final private int MAX = 10;
    private Semaphore sem;

    public Th1(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            Random gerador = new Random();
            int num_aleatorio = gerador.nextInt(MAX);
            String myname = Thread.currentThread().getName();

            System.out.println("[" + myname + "]: " + "INIT (" + num_aleatorio + ")");
            Thread.sleep(num_aleatorio * 1000);
            System.out.println("[" + myname + "]: " + "END");

            sem.release();  // permite que o Th2 avance
        } catch (InterruptedException iex) {
        }
    }
}
