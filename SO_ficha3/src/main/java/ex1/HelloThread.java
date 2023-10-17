/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

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
        System.out.println("Eu sou uma thread!");
    }

    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("Modo de uso: java Ex1 <comando>");
            System.exit(0);
        }

        int number = Integer.parseInt(args[0]);

        for (int i = 0; i < number; i++) {
            Thread thread = new Thread(new HelloThread(i));
            thread.start();
        }

    }
}
