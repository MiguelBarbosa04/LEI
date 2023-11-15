/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.ArrayList;

public class Worker extends Thread {

    ArrayList<String> frases;
    int numero;

    public Worker(ArrayList<String> f, int n) {
        super("Worker");
        this.frases = f;
        this.numero = n;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                frases.add("Frase da thread " + numero);
                Thread.sleep(500 + i * 10);
            } catch (Exception ex) {
            }
        }
    }
}
