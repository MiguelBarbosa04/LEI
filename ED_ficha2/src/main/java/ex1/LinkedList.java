package ex1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author migue
 */
public class LinkedList<T> {

    Node<T> head;
    Node<T> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    // Adicionar um elemento no final da lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remover um elemento da lista
    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                return;
            }
            current = current.next;
        }
    }

    // Imprimir todos os elementos da lista
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
