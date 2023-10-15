/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Miguel
 */
public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Inserir um nó na cabeça
    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Remover o primeiro nó da lista
    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    // Remover o último nó da lista
    public void removeLast() {
        if (tail == null) {
            return;
        }
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    // Verificar se a lista está vazia
    public boolean isEmpty() {
        return size == 0;
    }

    // Função para percorrer e imprimir todos os elementos da lista
    public void printList() {
        Node<T> current = head;
        System.out.print("Lista: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public T[] toArray() {
        ArrayList<T> elementsList = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            elementsList.add(current.data);
            current = current.next;
        }
        return (T[]) elementsList.toArray();
    }

    // Devolver um array de todos os elementos até uma dada posição
    public T[] toArrayUntilPosition(int position) {
        ArrayList<T> elementsList = new ArrayList<>();
        Node<T> current = head;
        int index = 0;
        while (current != null && index <= position) {
            elementsList.add(current.data);
            current = current.next;
            index++;
        }
        return (T[]) elementsList.toArray();
    }

    // Devolver um array de todos os elementos depois de uma dada posição
    public T[] toArrayAfterPosition(int position) {
        ArrayList<T> elementsList = new ArrayList<>();
        Node<T> current = head;
        int index = 0;
        while (current != null && index <= position) {
            current = current.next;
            index++;
        }
        while (current != null) {
            elementsList.add(current.data);
            current = current.next;
        }
        return (T[]) elementsList.toArray();
    }

    // Devolver um array de todos os elementos entre um intervalo de posições
    public T[] toArrayBetweenPositions(int startPosition, int endPosition) {
        ArrayList<T> elementsList = new ArrayList<>();
        Node<T> current = head;
        int index = 0;
        while (current != null && index < startPosition) {
            current = current.next;
            index++;
        }
        while (current != null && index <= endPosition) {
            elementsList.add(current.data);
            current = current.next;
            index++;
        }
        return (T[]) elementsList.toArray();
    }

    // Método para inserir um nó no final da lista
    public void insertAtTail(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public DoublyLinkedList<T> getEvenElements() {
        DoublyLinkedList<T> evenList = new DoublyLinkedList<>();
        Node<T> current = head;
        while (current != null) {
            if (current.data instanceof Integer) {
                Integer value = (Integer) current.data;
                if (value % 2 == 0) {
                    evenList.insertAtTail(current.data);
                }
            }
            current = current.next;
        }
        return evenList;
    }

    // Método para contar e remover elementos iguais a um dado valor
    public int countAndRemove(T value) {
        int count = 0;
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(value)) {
                Node<T> nextNode = current.next;
                Node<T> prevNode = current.prev;

                if (prevNode != null) {
                    prevNode.next = nextNode;
                } else {
                    head = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                } else {
                    tail = prevNode;
                }

                count++;
            }

            current = current.next;
        }

        return count;
    }
}
