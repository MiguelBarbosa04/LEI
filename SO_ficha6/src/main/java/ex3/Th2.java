/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.concurrent.*;
import java.util.Random;

public class Th2 implements Runnable {

    final private int MAX = 10;
    private Semaphore sem;

    public Th2(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            sem.acquire();  // aguarda que Th1 termine

            Random gerador = new Random();
            String myname = Thread.currentThread().getName();

            System.out.println("[" + myname + "]: " + gerador.nextInt(MAX));
        } catch (InterruptedException iex) {
        }
    }
}
