/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parte2_ex5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class MyQueue<T> {

    private List<T> elements = new ArrayList<>();

    public void enqueue(T element) {
        elements.add(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return elements.remove(0);
    }

    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return elements.get(0);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
