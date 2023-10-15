/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.util.Arrays;

/**
 *
 * @author Miguel
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);

        System.out.println("Lista inicial:");
        list.printList();

        list.removeFirst();
        System.out.println("Lista após remover o primeiro nó:");
        list.printList();

        list.removeLast();
        System.out.println("Lista após remover o último nó:");
        list.printList();

        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);
        list.insertAtHead(5);

        System.out.println("Lista completa:");
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println("Lista até a posição 2:");
        System.out.println(Arrays.toString(list.toArrayUntilPosition(2)));

        System.out.println("Lista depois da posição 2:");
        System.out.println(Arrays.toString(list.toArrayAfterPosition(2)));

        System.out.println("Lista entre as posições 1 e 3:");
        System.out.println(Arrays.toString(list.toArrayBetweenPositions(1, 3)));

        System.out.println("Lista original:");
        System.out.println(Arrays.toString(list.toArray()));

        DoublyLinkedList<Integer> evenList = list.getEvenElements();
        System.out.println("Lista com elementos pares:");
        System.out.println(Arrays.toString(evenList.toArray()));

        System.out.println("Lista original:");
        System.out.println(Arrays.toString(list.toArray()));

        int valueToRemove = 2;
        int count = list.countAndRemove(valueToRemove);

        System.out.println("Elementos removidos: " + count);
        System.out.println("Lista após remoção dos elementos iguais a " + valueToRemove + ":");
        System.out.println(Arrays.toString(list.toArray()));
    }
}
