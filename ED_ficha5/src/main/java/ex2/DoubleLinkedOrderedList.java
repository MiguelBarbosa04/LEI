/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import ex1.DoubleNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedOrderedList<T extends Comparable<T>> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoubleLinkedOrderedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (element.compareTo(head.getElement()) < 0) {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        } else {
            DoubleNode<T> current = head;
            while (current.getNext() != null && element.compareTo(current.getElement()) >= 0) {
                current = current.getNext();
            }

            if (current == tail && element.compareTo(current.getElement()) >= 0) {
                current.setNext(newNode);
                newNode.setPrevious(current);
                tail = newNode;
            } else {
                newNode.setNext(current);
                newNode.setPrevious(current.getPrevious());
                current.getPrevious().setNext(newNode);
                current.setPrevious(newNode);
            }
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T element = head.getElement();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }

        size--;
        return element;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T element = tail.getElement();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }

        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void displayList() {
        DoubleNode<T> current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
