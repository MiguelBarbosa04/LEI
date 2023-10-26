/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO_ficha4_repeat;

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
        try {
            while (true) {
                if (Thread.interrupted()) {
                    return;
                }
                Thread.sleep(1000);
                System.out.println("[" + myname + "]_Number:" + share.getNumber() + "(" + share.getName() + ")");

            }
        } catch (InterruptedException e) {
        }
    }

    public void setShare(SharedObj s) {
        share = s;
    }
}
