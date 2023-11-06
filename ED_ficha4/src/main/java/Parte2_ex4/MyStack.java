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
public class MyStack<T> {

    private Node<T> top;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}

