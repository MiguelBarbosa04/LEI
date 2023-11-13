/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

/**
 *
 * @author Miguel
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayUnorderedList<T> implements UnorderedListADT<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] list;
    private int size;

    public ArrayUnorderedList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void addToFront(T element) {
        if (size == list.length) {
            expandCapacity();
        }

        for (int i = size; i > 0; i--) {
            list[i] = list[i - 1];
        }

        list[0] = element;
        size++;
    }

    @Override
    public void addToRear(T element) {
        if (size == list.length) {
            expandCapacity();
        }

        list[size] = element;
        size++;
    }

    @Override
    public void addAfter(T element, T target) {
        if (!contains(target)) {
            throw new NoSuchElementException("Element not found in the list");
        }

        if (size == list.length) {
            expandCapacity();
        }

        int targetIndex = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(target)) {
                targetIndex = i;
                break;
            }
        }

        for (int i = size; i > targetIndex; i--) {
            list[i] = list[i - 1];
        }

        list[targetIndex + 1] = element;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T removedElement = list[0];

        for (int i = 0; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        list[size - 1] = null;
        size--;

        return removedElement;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        T removedElement = list[size - 1];
        list[size - 1] = null;
        size--;

        return removedElement;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(T element) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                T removedElement = list[i];
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[size - 1] = null;
                size--;
                return removedElement;
            }
        }

        throw new NoSuchElementException("Element not found in the list");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return list[size - 1];
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return list[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayUnorderedListIterator();
    }

    private void expandCapacity() {
        T[] largerList = (T[]) new Object[list.length * 2];
        for (int i = 0; i < size; i++) {
            largerList[i] = list[i];
        }
        list = largerList;
    }

    @Override
    public T remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        UnorderedListADT.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Spliterator<T> spliterator() {
        return UnorderedListADT.super.spliterator(); //To change body of generated methods, choose Tools | Templates.
    }

    private class ArrayUnorderedListIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list");
            }
            T element = list[currentIndex];
            currentIndex++;
            return element;
        }
    }
}
