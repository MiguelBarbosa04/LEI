/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author Miguel
 * @param <T>
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    private T[] queue;
    private int front, rear, size, capacity;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // Retorna o elemento na frente da fila sem removê-lo
    @Override
    public T first() {

        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        return queue[front];

    }

// Adiciona um elemento à fila
    @Override
    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia");
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

// Remove e retorna o elemento na frente da fila
    @Override
    public T dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        T removedElement = queue[front];
        front = (front + 1) % capacity; // Atualiza a posição frontal de forma cíclica
        size--;
        return removedElement;

    }

// Retorna uma representação em string da fila
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CircularArrayQueue: ");
        int current = front;
        for (int i = 0; i < size; i++) {
            sb.append(queue[current]).append(" ");
            current = (current + 1) % capacity;
        }
        return sb.toString();

    }

}
