/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class CounterThread extends Thread {
    protected Counter counter = null;
    
    public CounterThread(Counter counter){
        this.counter = counter;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            counter.add(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CounterThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
