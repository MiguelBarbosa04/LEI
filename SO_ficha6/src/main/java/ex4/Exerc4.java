/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

/**
 *
 * @author Miguel
 */
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Exerc4 implements Runnable {

    private final int threadNumber;
    private final Semaphore semaphore;
    private boolean isActive = false;

    public Exerc4(int threadNumber, Semaphore semaphore) {
        this.threadNumber = threadNumber;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                if (isActive) {
                    System.out.println("Thread " + threadNumber + " está ativa!");
                }
                Thread.sleep(1000); // Espera 1 segundo
                semaphore.release();
            } catch (InterruptedException e) {
            }
        }
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static void main(String[] args) {
        Semaphore[] semaphores = new Semaphore[20];
        Thread[] threads = new Thread[20];

        for (int i = 0; i < semaphores.length; i++) {
            semaphores[i] = new Semaphore(1);
        }

        for (int i = 0; i < threads.length; i++) {
            Exerc4 example = new Exerc4(i, semaphores[i]);
            threads[i] = new Thread(example);
            threads[i].start();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Insira o número da thread (0-19) para ativar/desativar ou -1 para sair: ");
            int input = scanner.nextInt();

            if (input == -1) {
                // Termina o programa
                scanner.close();
                System.exit(0);
            } else if (input >= 0 && input < 20) {
                Exerc4 example = new Exerc4(input, semaphores[input]);
                example.setActive(!example.isActive);
                System.out.println("Thread " + input + " está agora " + (example.isActive ? "ativa" : "inativa"));
            } else {
                System.out.println("Número de thread inválido. Insira um número entre 0 e 19.");
            }
        }
    }
}
