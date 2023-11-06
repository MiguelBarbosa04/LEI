/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parte2_ex4;

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
        MyQueueUsingTwoStacks<Integer> queue = new MyQueueUsingTwoStacks<>() {};

        // Adicione elementos à fila (enqueue)
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Verifique o tamanho da fila
        System.out.println("Tamanho da fila: " + queue.size());

        // Remova elementos da fila (dequeue) e imprima
        while (!queue.isEmpty()) {
            System.out.println("Elemento removido: " + queue.dequeue());
        }

        // Verifique se a fila está vazia
        System.out.println("A fila está vazia? " + queue.isEmpty());
    }
}


