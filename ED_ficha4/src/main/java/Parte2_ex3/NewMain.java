/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parte2_ex3;

/**
 *
 * @author Miguel
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Queue<Integer> q1 = new Queue<>();
        Queue<Integer> q2 = new Queue<>();

        // Adicione elementos às filas de entrada (devem estar ordenados)
        q1.enqueue(1);
        q1.enqueue(3);
        q1.enqueue(5);

        q2.enqueue(2);
        q2.enqueue(4);
        q2.enqueue(6);

        Queue<Integer> mergedQueue = q1.merged(q1, q2);

        while (!mergedQueue.isEmpty()) {
            System.out.print(mergedQueue.dequeue() + " ");
        }
    }
}
