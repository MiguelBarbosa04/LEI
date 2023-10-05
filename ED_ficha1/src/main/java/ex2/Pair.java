/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author migue
 */
public class Pair<T extends Comparable> {

    private T first;
    private T second;

    public Pair() {

        first = null;
        second = null;
    }

    public Pair(T firstT, T secondT) {
        first = firstT;
        second = secondT;
    }

    
    public T getFirst(){
        return first;
    }
    
    
    public T getSecond(){
        return second;
    }
    
    public T setFirst(){
        return this.first;
    }
    
    public T setSecond(){
        return this.second;
    }
    
    public T max() {
        if (first.compareTo(second) >= 0) {
            return first;
        } else {
            return second;
        }
    }

}
