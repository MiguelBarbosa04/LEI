package ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayOrderedList<T> implements OrderedListADT<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public ArrayOrderedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else if (((Comparable<T>) element).compareTo(head.getElement()) < 0) {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        } else {
            DoubleNode<T> current = head;
            while (current.getNext() != null && ((Comparable<T>) element).compareTo(current.getElement()) >= 0) {
                current = current.getNext();
            }

            if (current == tail && ((Comparable<T>) element).compareTo(current.getElement()) >= 0) {
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

    @Override
    public T remove() {
        throw new UnsupportedOperationException("Remove operation is not supported in an ordered list.");
    }

    @Override
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

    @Override
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

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.getElement();
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.getElement();
    }

    public boolean contains(T element) {
        DoubleNode<T> current = head;
        while (current != null) {
            if (element.equals(current.getElement())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode<T> current = head;

        sb.append("[");
        while (current != null) {
            sb.append(current.getElement());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayOrderedListIterator();
    }

    private class ArrayOrderedListIterator implements Iterator<T> {

        private DoubleNode<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = current.getElement();
            current = current.getNext();
            return element;
        }
    }
}
