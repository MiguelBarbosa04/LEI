/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author Miguel
 */
public class SharedObj {

    private int number;
    private String name;

    public  String getName() {
        return name;
    }

    public  int getNumber() {
        return number;
    }

    public synchronized void setName(String n) {
        name = n;
    }

    public synchronized void setNumber(int x) {
        number = x;
    }
}
