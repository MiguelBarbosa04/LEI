/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel
 */

package ex4;

public class Prints extends Thread {

    private int startValue;

    public Prints(int startValue) {
        this.startValue = startValue;
    }

    @Override
    public void run() {
        for (int i = startValue; i < startValue + 100; i++) {
            System.out.println(i);
        }
    }

}
