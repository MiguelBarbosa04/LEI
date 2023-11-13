/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;


/**
 *
 * @author Miguel
 */
public class DoubleLinkedUnorderedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private class Node<T> {
        T data;
        Node<T> next;
        Node<T> previous;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public DoubleLinkedUnorderedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        size++;
    }

    public boolean contains(T element) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void remove(T element) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(element)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.previous = null;
                    }
                } else if (current == tail) {
                    tail = current.previous;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }

                size--;
                return;
            }
            current = current.next;
        }
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

   
}
