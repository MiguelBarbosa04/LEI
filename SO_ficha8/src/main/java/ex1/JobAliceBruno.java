/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class JobAliceBruno implements Runnable {

    private BankAccount bank;
    private String name;

    public JobAliceBruno(BankAccount bank, String name) {
        this.bank = bank;
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 6; i++) {

            bank.putMoney();

            for (int j = 0; j < 10; j++) {

                Random random = new Random();
                int valorARetirar = random.nextInt(201) + 150;
                bank.getMoney(valorARetirar);

            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
