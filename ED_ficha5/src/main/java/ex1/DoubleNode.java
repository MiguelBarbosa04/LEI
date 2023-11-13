/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author Miguel
 */
public class DoubleNode<T> {

    private T element;
    private DoubleNode<T> previous;
    private DoubleNode<T> next;

    public DoubleNode(T element) {
        this.element = element;
        this.previous = null;
        this.next = null;
    }

    public T getElement() {
        return element;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
}
