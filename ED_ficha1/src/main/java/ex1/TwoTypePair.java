/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author migue
 */
public class TwoTypePair<T1, T2> {

    private T1 first;
    private T2 second;

    public TwoTypePair() {
        first = null;
        second = null;
    }

    public TwoTypePair(T1 firstItem, T2 secondItem) {
        first = firstItem;
        second = secondItem;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }
    // Definição de uma classe Genérica

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return ("first: " + first.toString() + "\n"
                + "second: " + second.toString());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else {
            TwoTypePair otherPair
                    = (TwoTypePair) otherObject;
            return (first.equals(otherPair.first)
                    && second.equals(otherPair.second));
        }
    }
}
