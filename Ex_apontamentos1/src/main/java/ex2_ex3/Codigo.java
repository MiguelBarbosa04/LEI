/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_ex3;

/**
 *
 * @author Miguel
 */
public class Codigo<T1, T2> {

    private T1 parte1;
    private T2 parte2;

    public Codigo(T1 parte1, T2 parte2) {
        this.parte1 = parte1;
        this.parte2 = parte2;
    }

    public T1 getParte1() {
        return parte1;
    }

    public T2 getParte2() {
        return parte2;
    }

    @Override
    public String toString() {
        return parte1.toString() + parte2.toString();
    }
}
