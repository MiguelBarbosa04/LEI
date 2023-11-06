/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author Miguel
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT<T> {

    private Node<T> front;  // Referência para o elemento na frente da fila
    private Node<T> rear;   // Referência para o elemento na parte traseira da fila
    private int size;       // Número de elementos na fila

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

// Adiciona um elemento à parte traseira da fila
    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }

        rear = newNode;
        size++;
    }

// Remove e retorna o elemento na frente da fila
    @Override
    public T dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        T data = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        System.out.println("O elemento " + data + " foi removido");
        return data;

    }

// Retorna o elemento na frente da fila sem removê-lo
    @Override
    public T first() {

        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        return front.data;

    }

// Retorna uma representação em string da fila
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedQueue: ");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();

    }

}
