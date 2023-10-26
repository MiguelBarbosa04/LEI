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
public class Run2 extends Thread {

    public SharedObj share;
    public int n;

    public Run2(SharedObj s, int i) {
        share = s;
        n = 1;
    }

    public void run() {
        String myname = Thread.currentThread().getName();
        try {
            share.setNumber(n);
            Thread.sleep(1000);
            //share.setNumber(n);
            System.out.println("[" + myname + "] _Number:" + share.getNumber());
            share.setName("share.name_definido_por:_" + myname);
        } catch (InterruptedException e) {
        }
    }

    public void setShare(SharedObj s) {
        share = s;
    }
}
