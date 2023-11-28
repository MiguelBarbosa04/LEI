/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Random;

/**
 *
 * @author migue
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();

        Thread Alice = new Thread(new JobAliceBruno(bank, "Alice"));
        Thread Bruno = new Thread(new JobAliceBruno(bank, "Bruno"));
        
        Alice.start();
        Bruno.start();
        
        try{
            Alice.join();
            Bruno.join();
            
        }catch(InterruptedException erro){
            erro.printStackTrace();
        }
    }

}
