/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

/**
 *
 * @author Miguel
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListADT<T> {

    void addToFront(T element);

    void addToRear(T element);

    void addAfter(T element, T target);

    boolean contains(T element);

    T remove(T element);

}
