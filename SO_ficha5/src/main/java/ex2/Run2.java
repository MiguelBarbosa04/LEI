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
public class Run2 extends Thread {

    public SharedObj share;
    public int n;

    public  Run2(SharedObj s, int i) {
        share = s;
        n = i;
    }

  
    public  void run() {
        String myname = Thread.currentThread().getName();
        share.setNumber(n);
        //share.setNumber(n);
        System.out.println("[" + myname + "] _Number:" + share.getNumber());
        share.setName("share.name_definido_por:_" + myname);
    }

    public  void setShare(SharedObj s) {
        share = s;
    }
}
