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
public class Run extends Thread {

    public SharedObj share;

    public Run(SharedObj s) {
        share = s;
    }

    public void run() {
        String myname = Thread.currentThread().getName();
        while (true) {
            if (Thread.interrupted()) {
                return;
            }

            System.out.println("[" + myname + "]_Number:" + share.getNumber() + "(" + share.getName() + ")");
            
        }
    }

    public void setShare(SharedObj s) {
        share = s;
    }
}
