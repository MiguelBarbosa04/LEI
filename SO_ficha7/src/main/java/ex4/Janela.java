/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.util.concurrent.TimeUnit;

public class Janela {

    public static void main(String args[]) {
        Buffer buffer = new Buffer();
        Thread produtor = new Thread(new Produtor(buffer), "Produtor");
        Thread consumidor = new Thread(new Consumidor(buffer), "Consumidor");

        produtor.start();
        consumidor.start();
    }

    public static class Buffer {
        private char[] buffer = new char[1];
        private boolean ocupado = false;

        public synchronized void armazenar(char valor) {
            while (ocupado) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer[0] = valor;
            ocupado = true;
            notifyAll();
        }

        public synchronized char obter() {
            while (!ocupado) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ocupado = false;
            notifyAll();
            return buffer[0];
        }
    }

    public static class Produtor implements Runnable {
        private Buffer buffer;

        public Produtor(Buffer buffer) {
            this.buffer = buffer;
        }

        public void run() {
            for (char c = 'A'; c <= 'Z'; c++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buffer.armazenar(c);
                System.out.println("[Produtor] - Caracter armazenado: " + c);
            }
        }
    }

    public static class Consumidor implements Runnable {
        private Buffer buffer;

        public Consumidor(Buffer buffer) {
            this.buffer = buffer;
        }

        public void run() {
            for (char c = 'A'; c <= 'Z'; c++) {
                char caractere = buffer.obter();
                System.out.println("[Consumidor] - Caracter lido: " + caractere);
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}