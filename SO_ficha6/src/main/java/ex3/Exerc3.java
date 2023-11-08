/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author Miguel
 */
import java.util.concurrent.*;

public class Exerc3 {

    @SuppressWarnings("empty-statement")
    public static void main(String args[]) {
        final Semaphore sem = new Semaphore(0);

        Thread th1 = new Thread(new Th1(sem), "Th1");
        Thread th2 = new Thread(new Th2(sem), "Th2");

        th1.start();
        th2.start();
    }
}
