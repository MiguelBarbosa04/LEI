/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = (int) (Math.random() * 1000);
        }

        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * 200;
            int endIndex = (i + 1) * 200;
            threads[i] = new SearchMaxThread(array, startIndex, endIndex);
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            latch.await(); // Aguarda até que todas as threads tenham terminado.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numThreads; i++) {
            int threadMax = ((SearchMaxThread) threads[i]).getMaxValue();
            if (threadMax > max) {
                max = threadMax;
            }
        }

        System.out.println("O maior valor encontrado no array é: " + max);
    }

}
