/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayOrderedListIterator<T> implements Iterator<T> {
    private DoubleNode<T> current = null;
    private DoubleNode<T> previous = null;
    private boolean canRemove = false;

    public ArrayOrderedListIterator(DoubleNode<T> head) {
        current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate");
        }

        T element = current.getElement();
        previous = current;
        current = current.getNext();
        canRemove = true;

        return element;
    }

    @Override
    public void remove() {
        if (!canRemove) {
            throw new IllegalStateException("You must call next() before remove()");
        }

        if (previous == null) {
            throw new IllegalStateException("Cannot remove before calling next()");
        }

        if (previous.getPrevious() == null) {
            // Removing the first element
            if (current == null) {
                // The only element in the list
                current = previous = null;
            } else {
                // The first element but not the only one
                current.setPrevious(null);
                previous = null;
            }
        } else {
            if (current == null) {
                // Removing the last element
                previous.getPrevious().setNext(null);
                previous = null;
            } else {
                previous.getPrevious().setNext(current);
                current.setPrevious(previous.getPrevious());
                previous = null;
            }
        }

        canRemove = false;
    }
}
